package o1.inputs

import io.StdIn.*

/** A little function for experimenting with user input. The function reads in 
  * a line of user input and uses it both as a string and as a number. */
@main def inputTest() =

  val input = readLine("Please enter an integer: ")
  if input.toIntOption.isDefined then

    val digits = input.length
    println(s"Your number is $digits digits long.")

    val multiplied = input.toInt * digits
    println(s"Multiplying it by its length gives $multiplied.")

  else
    println("That is not a valid input. Sorry!")

end inputTest