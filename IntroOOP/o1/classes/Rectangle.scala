package o1.classes
import o1.*

// This class is introduced in Chapter 2.4.

class Rectangle(val side1: Double, val side2: Double):

  def area = this.side1 * this.side2
  def makePic(c: Color) =rectangle(this.side1, this.side2, c)

end Rectangle

class ColoredRectangle(val side1: Double, val side2: Double, val color: Color):

  def area = this.side1 * this.side2
  def makePic = rectangle(this.side1, this.side2, this.color)

end ColoredRectangle
