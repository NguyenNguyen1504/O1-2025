package o1.flappy

import o1.*

class Game:

  val bug = Bug(Pos(100,40))
  val obstacles = Vector(Obstacle(70),Obstacle(30),Obstacle(20))
  def timePasses() =
    bug.fall()
    this.obstacles.foreach(_.approach())
  def activateBug() = bug.flap(15)
  def isLost =
    this.obstacles.exists( _.touches(this.bug) ) || !this.bug.isInBounds
//    var crashed = false
//    for obstacle <- this.obstacles do
//      if obstacle.touches(this.bug) then
//        crashed = true
//    crashed || !this.bug.isInBounds

end Game
