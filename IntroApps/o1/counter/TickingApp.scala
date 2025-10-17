package o1.counter
import o1.*

// This program is introduced in Chapter 3.1.

val tickCounter = Counter(0)
val blackBackground = rectangle(500, 500, Black)

object tickView extends View("An app that ticks"):

  def makePic =
    blackBackground.place(rectangle(tickCounter.value, tickCounter.value, White).clockwise(tickCounter.value - Counter(0).value), Pos(250, 250))
  override def onTick() =
    tickCounter.advance()

end tickView


@main def runTickProgram() =
  tickView.start()

