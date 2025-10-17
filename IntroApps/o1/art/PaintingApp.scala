package o1.art
import o1.*

// This program is introduced in Chapter 3.1.

val artwork = ArtProject(rectangle(600, 600, White))

object painterView extends View("Painting App"):

  def makePic = artwork.image

  override def onMouseMove(mousePos: Pos) = artwork.paint(mousePos)
  override def onClick(clickEvent: MouseClicked) = artwork.changeColor(clickEvent.clicks)

end painterView


@main def launchPaintingApp() =
  painterView.start()

