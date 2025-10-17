package o1.snake

import o1.*

// Represents games of Snake. A SnakeGame object is mutable: it tracks the
// position and heading of a snake as well as the position of a food item
// that is available for the snake to eat next.
class SnakeGame(initialPos: GridPos, initialHeading: CompassDir):

  private var segments = Vector(initialPos) // container: the locations of every snake segment, in order from head to tail
  var snakeHeading = initialHeading         // most-recent holder (the direction most recently set for the snake)
  var nextFood = randomEmptyLocation()      // most-recent holder (a changing random location for the next available food item)

  def snakeSegments = this.segments

  def isOver =
    val head = this.segments.head
    val validCoords = 1 until SizeInSquares
    val collidedWithWall = !validCoords.contains(head.x) || !validCoords.contains(head.y)
    val collidedWithItself = this.segments.tail.contains(this.segments.head)

    // TODO: the snake should also collide with itself; see ebook text
    collidedWithWall || collidedWithItself

  // This gets repeatedly called as the game progresses. It advances the snake by one
  // square in its current heading. If the snake finds food, it grows by one segment,
  // the current nextFood vanishes, and new food is placed in a random location.
  def advance() =
    if this.segments.head.neighbor(this.snakeHeading) == nextFood then
      this.segments = nextFood +: this.segments
      nextFood = randomEmptyLocation()
    else
      this.segments = (this.segments.head.neighbor(this.snakeHeading) +: this.segments).init

     // TODO: missing; see ebook text and replace this with an actual implementation


  // Randomly returns the GridPos of a single empty square on the grid.
  // Note to students: Do not modify this method. You don’t need to understand
  // its code at this time. You can call it, however, to randomize food locations.
  private def randomEmptyLocation(): GridPos =
    val screenFull = this.snakeSegments.size >= (SizeInSquares - 1) * (SizeInSquares - 1)
    if !screenFull then
      def randomLocs = LazyList.continually( GridPos.random(1, SizeInSquares) )
      randomLocs.dropWhile(this.snakeSegments.contains).head
    else
      GridPos(-1, -1)

end SnakeGame

