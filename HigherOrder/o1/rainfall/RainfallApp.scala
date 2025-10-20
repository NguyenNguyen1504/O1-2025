package o1.rainfall
import scala.io.StdIn.*

object RainfallApp extends App:

  val askForRainfall = LazyList.continually(readLine("Enter rainfall (or 999999 to stop): ").toIntOption)
  val checking = askForRainfall.flatten.takeWhile( _ != 999999 ).filter( _ >= 0)
  if checking.isEmpty then
    println("No valid data. Cannot compute the average.")
  else
    println(s"The average is ${checking.sum/checking.size}.")


end RainfallApp