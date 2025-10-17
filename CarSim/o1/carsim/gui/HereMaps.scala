////////////////// NOTE TO STUDENTS //////////////////////////
// For the purposes of our course, it’s not necessary
// that you understand or even look at the code in this file.
//////////////////////////////////////////////////////////////

package o1.carsim.gui

import org.openstreetmap.gui.jmapviewer.tilesources.AbstractOsmTileSource
import org.openstreetmap.gui.jmapviewer.interfaces.TileSource.TileUpdate

import scala.util.*
import requests.RequestFailedException
import ujson.Value as Json
import upickle.default.{ReadWriter, macroRW, read}
import upickle.implicits.key

import scala.collection.immutable.ArraySeq

/** The singleton object `HereMaps` provides an interface to the Here.com routing and map service over the internet.
  *
  * **NOTE TO STUDENTS: In this course, you don’t need to understand how this object works or can be used.**
  *
  * (This class is not really a part of the GUI *per se*. It is here as an artifact of the programming assigment.) */
object HereMaps:       // See: https://developer.here.com/documentation

  def findRoute(origin: String, destination: String): Seq[Leg] =

    val searchURL: String = "https://router.hereapi.com/v8/routes"

    val originCoords      = parseCoords(origin)      getOrElse error("Invalid origin of travel: " + origin)
    val destinationCoords = parseCoords(destination) getOrElse coordsOfNamedPlace(destination, maybeNear=originCoords)
    val searchParameters  = Map("apiKey" -> APIKey, "transportMode" -> "car", "origin" -> s"$originCoords",
                                "destination" -> s"$destinationCoords", "routingMode" -> "fast", "return" -> "polyline,summary")

    val responseBody: String = Try( requests.get(searchURL, params=searchParameters) ) match
      case Success(response)                       => attempt(response.text(), "No routa data received.")
      case Failure(failed: RequestFailedException) => error("HERE Maps failed to provide a route to that location.")
      case Failure(anyOtherProblem)                => error("Failed to access HERE Maps route search. Please check your network connection.")

    val directionsJson = attempt(ujson.read(responseBody), "Received an invalid JSON response from the HERE Maps route service.")

    Try( directionsJson("routes").arr(0) ) match
      case Failure(noRouteInResponse) =>
        error("HERE Maps did not find a route to that location.")
      case Success(firstAndOnlyResult) =>
        val legsAsJson = firstAndOnlyResult("sections").arr.toSeq
        legsAsJson.map( read[Leg](_) )

  end findRoute

  enum TravelType:
    case Driving, InTransit

  case class Coords(val lat: Double, val lng: Double):
    override def toString = s"${lat},${lng}"

  case class Segment(val distance: Double, val origin: Coords, val destination: Coords)

  case class Leg(id: String, @key("type") travelTypeString: String, departure: Json, arrival: Json, val summary: Json, val polyline: String):

    val travelType = if travelTypeString == "transit" then TravelType.InTransit else TravelType.Driving

    lazy val segments: Seq[Segment] =
      val totalDistance  = this.summary("length").num.toInt
      def segmentWeight(a: Coords, b: Coords) =
        math.hypot(b.lat - a.lat, b.lng - a.lng)
      val points: Seq[Coords] = decode(polyline).toSeq
      val weightsAndEnds = for (from, to) <- points.zip(points.tail)
                           yield (segmentWeight(from, to), from, to)
      val sumOfWeights = weightsAndEnds.foldLeft(0.0)( _ + _(0) )
      def estimatedLength(weight: Double) = // the length in meters for each polyline segment is not provided, so we use this simple metric that is good enough for current purposes
        weight / sumOfWeights * totalDistance
      for
        (dist, from, to) <- weightsAndEnds
      yield
        Segment(estimatedLength(dist), from, to)

    private def decode(polyline: String) =
      import com.here.flexpolyline.PolylineEncoderDecoder
      import PolylineEncoderDecoder.LatLngZ as JavaCoord
      def asCoords(element: AnyRef): Coords =
        val jCoord = element.asInstanceOf[JavaCoord]
        Coords(jCoord.lat, jCoord.lng)
      val decoded = PolylineEncoderDecoder.decode(polyline).toArray
      decoded.map(asCoords)

  end Leg



  def coordsOfNamedPlace(placeName: String, maybeNear: Coords): Coords =
    val searchURL = "https://geocode.search.hereapi.com/v1/geocode"
    val searchParameters = Map("apiKey" -> APIKey, "q" -> placeName, "limit" -> "1",
                               "at" -> s"${maybeNear.lat},${maybeNear.lng},200000")
    val response     = attempt(requests.get(searchURL, params = searchParameters), "Failed to access HERE Maps coordinate search. Please make sure your network connection is working.")
    val locationJson = attempt(ujson.read(response.text()), "Received an invalid JSON response from HERE Maps coordinate search.")
    val coordsJson   = attempt(locationJson("items")(0)("position"), s"No coordinates available for '$placeName'.")
    Coords(coordsJson("lat").num, coordsJson("lng").num)
  end coordsOfNamedPlace

  // read-writers for converting between json and case classes:
  object Coords  { implicit val rw: ReadWriter[Coords]  = macroRW }
  object Segment { implicit val rw: ReadWriter[Segment] = macroRW }
  object Leg     { implicit val rw: ReadWriter[Leg]     = macroRW }


  private def error(message: String) = throw CarMap.DirectionsException(message)
  private def attempt[Result](action: =>Result, message: String) = Try(action) getOrElse error(message)

  private val HttpOK = 200

  private val LatCommaLong =
    val Comma = """\s*,\s*"""
    val Coord = """((?:-)?\d+(?:\.\d+)?)"""
    (Coord + Comma + Coord).r

  private def parseCoords(coordsString: String): Option[Coords] =
    coordsString match
      case LatCommaLong(lat, lng) => Try(Coords(lat.toDouble, lng.toDouble)).toOption
      case anythingElse           => None


  class TileSource extends AbstractOsmTileSource("HERE", ""):

    override def getBaseUrl = s"https://maps.hereapi.com/v3/base/mc"

    override def getTileUrl(zoom: Int, tileX: Int, tileY: Int) =
      this.getBaseUrl + s"/$zoom/$tileX/$tileY/png?apiKey=$APIKey"

    override def getTileUpdate: TileUpdate = TileUpdate.IfNoneMatch

    override def getMaxZoom = 16

  end TileSource


  // Please do not use this API key in other projects. You can create your own for free at Here.com if you want.
  private lazy val APIKey = "L_n2nkik-dz7DLP0cb3sLlYNDfo86F4Nnq4Pdzt_oUw"

end HereMaps



