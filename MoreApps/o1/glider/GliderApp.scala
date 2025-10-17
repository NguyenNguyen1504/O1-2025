package o1.glider
import o1.*

// This program is introduced in Chapter 3.6.

/** A simple app that lets the user control a “glider” onscreen. */
@main def runGliderApp() =
  gliderView.start()

val glider = Glider(Pos(350, 350), 25)

object gliderView extends View("Glider App"):

  private val background = square(700, LightBlue)
  private val gliderPic = Pic("glider.png").scaleTo(50)

  def makePic =
    val rotatedglider = gliderPic.counterclockwise(glider.heading.toDegrees)
    background.place(rotatedglider, glider.pos)

  override def onTick() =
    glider.glide()

  override def onKeyDown(key: Key) =
    if key == Key.Up then
      glider.isAccelerating = true
    else if key == Key.Left then
      glider.isTurningLeft = true
    else if key == Key.Right then
      glider.isTurningRight = true
    else
      ()

// TODO: other actions

  override def onKeyUp(key: Key) =
    if key == Key.Up then
      glider.isAccelerating = false
    else if key == Key.Left then
      glider.isTurningLeft = false
    else if key == Key.Right then
      glider.isTurningRight = false
    else
      ()
    // TODO: other actions

end gliderView