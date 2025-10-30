package o1.robots

import o1.*

import scala.math.abs


// TODO: proper implementation missing completely
class Lovebot(name: String, body: RobotBody, val beloved: RobotBody) extends RobotBrain(name, body):

  def moveBody() =
    val target = this.beloved.location
    val start = this.body.location
    def isAlreadyClose = (abs(start.xDiff(target)) + abs(start.yDiff(target))) == 1
    val x = start.xDiff(target)
    val y = start.yDiff(target)
    def direction =
      if abs(x) >= abs(y) then
        if x > 0 then
          grid.CompassDir.East
        else
          grid.CompassDir.West
      else
        if y > 0 then
          grid.CompassDir.South
        else
          grid.CompassDir.North
    if !isAlreadyClose then
      this.body.moveTowards(direction)

  private def printing() = println(this.body.world.neighbors(this.body.location, false))


end Lovebot




