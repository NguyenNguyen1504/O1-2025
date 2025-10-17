package o1.burr
import o1.*

val burr = Burr()  // Here’s an instance of class Burr. It serves as the view’s model.

// Insert your code here and finish the main function below.
object window extends View("Burr App"):
  def makePic = background.place(burrPic, burr.location)
  override def onMouseMove(mousePos: Pos) = burr.location = mousePos
end window



@main def launchGUI() =
  window.start()

