package o1.football3

import scala.collection.mutable.Buffer
import scala.math.abs

class Season:

  private val allMatches = Buffer[Match]()
  private var biggestMargin: Option[Match] = None

  def addResult(newResult: Match) =
    this.biggestMargin match {
      case
        None => this.biggestMargin = Some(newResult)
      case
        Some(oldResult) =>
        if abs(oldResult.goalDifference) >= abs(newResult.goalDifference) then
          this.biggestMargin = Some(oldResult)
        else
          this.biggestMargin = Some(newResult)
    }
    this.allMatches += newResult

  def biggestWin = this.biggestMargin

  def latestMatch = matchNumber(this.allMatches.size - 1)

  def matchNumber(number: Int) = this.allMatches.lift(number)

  def numberOfMatches = this.allMatches.size

end Season



