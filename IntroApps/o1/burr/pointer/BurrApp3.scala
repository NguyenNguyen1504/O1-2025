package o1.burr.pointer
import o1.*
import o1.burr.*

val burr = Burr()

object window extends View(""):
  def makePic =
    val bgcenter = Pos(background.width/2.0,background.height/2.0)
    var myLine = line(bgcenter, (bgcenter.add(burr.location)).divide(2.0), Black)
    background.place(myLine, bgcenter)
  override def onMouseMove(mousePos: Pos) = burr.location = mousePos
end window



@main def launchGUI() =
  window.start()