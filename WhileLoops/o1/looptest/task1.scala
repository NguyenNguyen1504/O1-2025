package o1.looptest

// This task is part of Chapter 9.1.

import scala.io.StdIn.*

@main def whileTask1() =
  // TODO: Reimplement this program using a while loop instead of lazy-lists.
  def report(input: String) = "The input is " + input.length + " characters long."

  var input = readLine("Enter some text: ")
  while input != "please" do
    println(report(input))
    input = readLine("Enter some text: ")

