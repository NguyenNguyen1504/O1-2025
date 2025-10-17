package o1.flappy

import o1.*

// Define class Bug here.
class Bug(private var currentPos: Pos):
  val radius: Int = 15
  private var yVelocity = 0.0
  def pos = this.currentPos
  private def move(addedY: Double) = this.currentPos = this.currentPos.addY(addedY).clampY(0,350)

  def flap(f: Double) = this.yVelocity = -f
  def fall() =
    yVelocity += 2.0
    move(yVelocity)
    if this.currentPos.y == 350 then
      yVelocity = 0

  override def toString = s"center at ${this.pos}, radius ${this.radius}"

  def isInBounds = this.pos.y > 0 && this.pos.y < 350



end Bug