package o1.rainfall

// What goes here is described in Chapter 7.1.

def averageRainfall(stats: Vector[Int]):Option[Int] =
  val checking = stats.takeWhile( _ != 999999 ).filter( _ >= 0 )
  if checking.isEmpty then
    None
  else
    Some(checking.sum / checking.size)

def averageRainfallFromStrings(stats: Vector[String]):Option[Int] =
  averageRainfall(stats.flatMap(_.toIntOption))

def drySpell(stats: Vector[Int], length: Int) =
  stats.sliding(length).indexWhere( slice => slice.forall( num => num >= 0 && num <= 5 && num != 999999 ) )