package o1.looptest

// This task is part of Chapter 9.1.

import scala.io.StdIn.*

// Here is an example run (with user inputs in *asterisks*):
//
// I will compute the squares of positive integers and discard other numbers.
// To stop, just hit Enter.
// Please enter the first number: *10*
// Its square is: 100
// Another number: *0*
// Another number: *-1*
// Another number: *20*
// Its square is: 400
// Another number: *30*
// Its square is: 900
// Another number: *0*
// Another number: *40*
// Its square is: 1600
// Another number:
// Done.
// Number of discarded inputs: 3

@main def whileTask2() =

  println("I will compute the squares of positive integers and discard other numbers.")
  println("To stop, just hit Enter.")
  var discarded = 0
  var input = readLine("Please enter the first number: ")

  while input.nonEmpty do
    if input.toInt <= 0 then
      discarded += 1
    else
      println(s"Its square is: ${input.toInt*input.toInt}")

    input = readLine("Another number: ")

  println("Done.")
  println(s"Number of discarded inputs: $discarded")


end whileTask2

