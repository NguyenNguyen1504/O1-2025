package o1.shapes
import scala.math.*

// TODO: define RightTriangle properly
class RightTriangle(val leg1: Double, val leg2: Double) extends Shape:

  def area = this.leg1 * this.leg2 /2.0
  def hypotenuse = hypot(this.leg1, this.leg2)
  def perimeter = this.leg1 + this.leg2 + hypotenuse

end RightTriangle
