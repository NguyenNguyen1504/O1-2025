package o1.odds

// This program is developed in Chapters 2.7 and 3.4.
// It creates a single Odds object and uses some of its methods.

import scala.io.StdIn.*

object OddsTest1 extends App:

  def requestOdds() =
    val firstInput = readInt()
    val secondInput = readInt()
    val odds = Odds(firstInput, secondInput)
    odds

  println("Please enter the odds of an event as two integers on separate lines.")
  println("For instance, to enter the odds 5/1 (one in six chance of happening), write 5 and 1 on separate lines.")

  val odds1 = requestOdds()

  println("The odds you entered are:")
  println(s"In fractional format: ${odds1.fractional}")
  println(s"In decimal format: ${odds1.decimal}")
  println(s"In moneyline format: ${odds1.moneyline}")
  println(s"Event probability: ${odds1.probability}")
  println(s"Reverse odds: ${odds1.not}")
  println(s"Odds of happening twice: ${odds1.both(odds1)}")

  println("Please enter the size of a bet:")
  val thirdInput = readDouble()
  println(s"If successful, the bettor would claim ${odds1.winnings(thirdInput)}")

  println("Please enter the odds of a second event as two integers on separate lines.")

  val odds2 = requestOdds()

  println(s"The odds of both events happening are: ${odds1.both(odds2)}")
  println(s"The odds of one or both happening are: ${odds1.either(odds2)}")
end OddsTest1
