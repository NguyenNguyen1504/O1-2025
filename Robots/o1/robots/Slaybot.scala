package o1.robots

import o1.{grid, *}

// TODO: a proper implementation is completely missing
class Slaybot(name: String, body: RobotBody) extends RobotBrain(name, body):

  def moveBody() =

    val directions = Vector[CompassDir](North, East, South, West)
    var index = 0
    def checkDirection(direction: CompassDir) =
      var scanner = this.body.location
      var nextNeighborSquare = this.body.world.elementAt(scanner.neighbor(direction))
      var countSteps = 0
      while nextNeighborSquare.isEmpty do
        scanner = scanner.neighbor(direction)
        countSteps += 1
        nextNeighborSquare = this.body.world.elementAt(scanner.neighbor(direction))
      nextNeighborSquare.robot match
        case Some(robot) =>
          if robot.isIntact then
            robot.destroy()
            var i = 0
            while i <= countSteps do
              this.body.moveTowards(direction)
              i+=1
            //move this robot to adjacent square
            true
          else false
        case None => false

    while !checkDirection(directions(index)) && index < 3 do
        index += 1

end Slaybot



