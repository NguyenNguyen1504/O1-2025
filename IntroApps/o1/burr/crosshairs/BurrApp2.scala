package o1.burr.crosshairs
import o1.*
import o1.burr.*

val burr = Burr()

object window extends View(""):
  def makePic =
    var verLine = line(Pos(burr.location.x, 0), Pos(burr.location.x, background.height), Black)
    var horLine = line(Pos(0, burr.location.y), Pos(background.width, burr.location.y), Black)
    (background.place(verLine, Pos(burr.location.x, 0))).place(horLine, Pos(0, burr.location.y))
  override def onMouseMove(mousePos: Pos) = burr.location = mousePos
end window



@main def launchGUI() =
  window.start()
