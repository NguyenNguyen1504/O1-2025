package o1.hofuncs
import o1.*

// This program is introduced in Chapter 6.1.

// Implement an effectful function transformEachElement. It takes as parameters
//  1) a bufferful of names, and
//  2) a function that transforms a single string to another.
//
// transformEachElement should use the given function to replace each element
// of the buffer with a transformed one. You will need to choose appropriate
// types and names for its parameters.
//
// An example use case is shown below. Leave it there and uncomment the
// indicated line.

// TODO: Define transformEachElement here
def transformEachElement(buffer: Buffer[String], transformer: String => String) =
  for i <- buffer.indices do
    buffer(i) = transformer(buffer(i))




@main def task8() =
  val exampleNames = Buffer("Umberto Eco", "James Joyce", "Dorothy Dunnett")
  println(exampleNames.mkString(", "))     // prints: Umberto Eco, James Joyce, Dorothy Dunnett
   transformEachElement(exampleNames, shortenName) // TODO: uncomment this line
  println(exampleNames.mkString(", "))     // should print: U. Eco, J. Joyce, D. Dunnett


// Abbreviates a given two-word name. For example: "Volodymyr Zelenskyi" → "V. Zelenskyi"
def shortenName(fullName: String) =
  val words = fullName.split(" ")
  val initial = words(0).take(1)
  val surname = words(1)
  s"$initial. $surname"

