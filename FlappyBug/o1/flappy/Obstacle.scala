package o1.flappy

import o1.*

import scala.util.Random

// This class is introduced in Chapter 2.6.

class Obstacle(val radius: Int):
  private var currentPos = randomLaunchPosition()
  def pos =  this.currentPos

  def approach() =
    this.currentPos =
      if this.isActive then
        this.currentPos.addX(-ObstacleSpeed)
      else
        randomLaunchPosition()
  override def toString = "center at " + this.pos + ", radius " + this.radius

  def touches(bug: Bug) =
    var centerDistance = bug.pos.distance(this.pos)
    val minDistance = bug.radius + this.radius
    centerDistance < minDistance

  def isActive = this.currentPos.x >= -radius

  private def randomLaunchPosition() =
    val launchX = 1000 + this.radius + Random.nextInt(500)
    val launchY = Random.nextInt(400)
    Pos(launchX, launchY)

end Obstacle
