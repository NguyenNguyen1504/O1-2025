import scala.io.StdIn.*

@main def surround() =
  val t1 = readLine("Please enter a string: ")
  val t2 = readLine("And a surrounding string: ")
  println(s"$t2$t1$t2")