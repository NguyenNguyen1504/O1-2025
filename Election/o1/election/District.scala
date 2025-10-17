package o1.election

import scala.collection.mutable.Buffer           // This is useful in early versions of the class.

class District (val name: String, val seats: Int, val candidates: Vector[Candidate]):

  def candidatesFrom(party: String): Vector[Candidate] =
    this.candidates.filter( _.party == party )


  def printCandidates(): Unit =
    this.candidates.foreach( candidate => println(candidate.toString))

  override def toString = s"${this.name}: ${this.candidates.size} candidates, ${this.seats} seats"

  def topCandidate: Option[Candidate] =
    var better = this.candidates(0)
    for candidate <- this.candidates do
      if candidate > better then
        better = candidate
    Some(better)

  private def countVotes(candidates: Vector[Candidate]) = candidates.foldLeft(0)( _ + _.votes )

  def totalVotes = countVotes(this.candidates)

  def totalVotes(party: String) = countVotes(candidatesFrom(party))

end District