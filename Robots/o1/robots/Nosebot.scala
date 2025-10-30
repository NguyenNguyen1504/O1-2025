package o1.robots

import o1.*

// TODO: proper implementation missing completely
class Nosebot(name: String, body: RobotBody) extends RobotBrain(name, body):

  override def mayMove(direction: CompassDir) =
    val neighbor = this.body.location.neighbor(direction)
    this.body.world(neighbor).isEmpty

  def attemptMove() =
    if this.mayMove(this.body.facing) then
      this.body.moveTowards(this.body.facing)
      true
    else
      this.body.spinClockwise()
      false

/*  def moveBody() =
    var attempt = this.attemptMove()
    while !attempt do
      attempt = this.attemptMove()
*/
  def moveBody() =
    LazyList.continually(attemptMove()).find( _ == true )

end Nosebot



