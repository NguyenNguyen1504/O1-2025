package o1.burr.slow
import o1.*
import o1.burr.*

val burr = Burr()

object window extends View(""):
  var latestCursorPos = Pos(0,0)
  def makePic = background.place(burrPic, burr.location)
  override def onMouseMove(mousePos: Pos) = latestCursorPos = mousePos
  override def onTick() = burr.location = ((burr.location.multiply(9.0)).add(latestCursorPos)).divide(10.0)
end window



@main def launchGUI() =
  window.start()

