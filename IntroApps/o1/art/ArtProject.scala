package o1.art
import o1.*

// This class is introduced in Chapter 3.1.

class ArtProject(canvas: Pic):
  var image = canvas                          // gatherer
  var brush = circle(10, Black)               // most-recent holder
  var colorIndex = 0
  val palette = Buffer(Black, Red, Green, Blue)

  def drawingColor = palette(this.colorIndex)
  def changeColor(countedClick: Int) =
    this.colorIndex = countedClick - 1
    this.brush = circle(10,drawingColor)
  def paint(where: Pos) = this.image = this.image.place(this.brush, where)
end ArtProject
