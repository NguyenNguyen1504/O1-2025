package o1.flappy

import o1.*

// This class is introduced in Chapter 2.7.
def scenery =
  val sky        = rectangle(ViewWidth, ViewHeight,  LightBlue)
  val ground     = rectangle(ViewWidth, GroundDepth, SandyBrown)
  val trunk      = rectangle(30, 250, SaddleBrown)
  val foliage    = circle(200, ForestGreen)
  val tree       = trunk.onto(foliage, TopCenter, Center)
  val rootedTree = tree.onto(ground, BottomCenter, Pos(ViewWidth / 2, 30))
  sky.place(rootedTree, BottomLeft, BottomLeft)


val bugPic = Pic("ladybug.png")


def makeRockPic(obstacle: Obstacle) = circle(obstacle.radius * 2, Black)


val game = Game()


object flappyView extends View("FlappyBug"):
  var background = scenery
  def makePic =
    game.obstacles.foldLeft(background)( (background, obstacle) => background.place(makeRockPic(obstacle), obstacle.pos) ).place(bugPic,game.bug.pos)
/*
    for obstacle <- game.obstacles do
      obsPic = obsPic.place(makeRockPic(obstacle), obstacle.pos)
    obsPic.place(bugPic,game.bug.pos)
*/
  override def onKeyDown(pressedKey: Key) = if pressedKey == Key.Space then game.activateBug()
  override def onTick() =
    game.timePasses()
    this.background = this.background.shiftLeft(2)
  override def isDone = game.isLost
end flappyView


@main def launchFlappy() =
  flappyView.start()









