package o1.robots

import scala.util.Random
import o1.CompassDir
import o1.grid.CompassDir.{East, North, South, West}

// TODO: proper implementation missing completely
class Staggerbot(name: String, body: RobotBody, randomSeed: Int) extends RobotBrain(name, body):
  val generator = Random(randomSeed)

  private def randomDirection =
    val directions = Vector[CompassDir](North, East, South, West)
    directions(generator.nextInt(4))



  def moveBody() =
    val move = this.body.moveTowards(randomDirection)
    if move then
      this.body.spinTowards(randomDirection)
    else
      ()

end Staggerbot



