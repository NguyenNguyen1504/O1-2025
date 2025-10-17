package o1.football3

import scala.collection.mutable.Buffer


/** The class `Match` represents match results in a football match statistics program.
  * A match is played between teams from two clubs: a home club and an away club.
  * Goals scored by players of either team can be added to the match object with the
  * method `addGoal`.
  *
  * The class is expected to be used so that a match object with no goals is initially
  * created as a real-life match starts. Goals are added incrementally as the match
  * progresses. (A match object has mutable state.)
  *
  * @param home  the club whose team plays at home in the match
  * @param away  the club whose team plays away in the match */
class Match(val home: Club, val away: Club):

  // Inherited from Football1

  def location = home.stadium

  private var homeCount = 0
  private var awayCount = 0

  def homeGoals = this.homeCount
  def awayGoals = this.awayCount
  def goalDifference = this.homeCount - this.awayCount
  def totalGoals = this.homeGoals + this.awayGoals
  def isHomeWin = this.homeGoals > this.awayGoals
  def isAwayWin = this.homeGoals < this.awayGoals
  def isTied = this.homeGoals == this.awayGoals
  def isGoalless = this.totalGoals == 0
  def isHigherScoringThan(anotherMatch: Match) =
    this.totalGoals > anotherMatch.totalGoals

  override def toString =
    val result =
      if this.isTied then
        if isGoalless then
          "tied at nil-nil"
        else
          s"tied at ${this.homeGoals}-all"
      else if this.isHomeWin then
        s"${this.homeGoals}-${this.awayGoals} to ${this.home.name}"
      else
        s"${this.awayGoals}-${this.homeGoals} to ${this.away.name}"
    s"${home.name} vs. ${away.name} at ${this.location}: ${result}"

  // Inherited from Football1


  // New in Football2

  private val homeScorers = Buffer[Player]()    // container: goalscorers of the home team are added here
  private val awayScorers = Buffer[Player]()    // container: goalscorers of the away team are added here
  private var homeScorersList: Vector[Player] = Vector()
  private var awayScorersList: Vector[Player] = Vector()

  def addGoal(scorer: Player): Unit =
    if scorer.employer == this.home then
      this.homeScorers += scorer
      this.homeCount += 1
      this.homeScorersList = this.homeScorersList ++ Vector(scorer)
    if scorer.employer == this.away then
      this.awayScorers += scorer
      this.awayCount += 1
      this.awayScorersList = this.awayScorersList ++ Vector(scorer)

  def allScorers: Vector[Player] = this.homeScorersList ++ this.awayScorersList

  def winningScorerName: String =
    var neededGoal = 0
    if isHomeWin then
      neededGoal = this.awayGoals
      this.homeScorersList(neededGoal).name
    else if isAwayWin then
      neededGoal = this.homeGoals
      this.awayScorersList(neededGoal).name
    else
      "no winning goal"

  def hasScorer(possibleScorer: Player) = allScorers.indexOf(possibleScorer) >= 0

  def winnerName =
    winner match
      case Some(winningclub) => winningclub.name
      case None => "no winner"


  // New in Football2


  // New in Football3

  def winner: Option[Club] =
    if this.isTied then
      None
    else if this.isHomeWin then
      Some(this.home)
    else
      Some(this.away)

  def winningScorer: Option[Player] =
    var neededGoal = 0
    if isHomeWin then
      neededGoal = this.awayGoals
      Some(this.homeScorersList(neededGoal))
    else if isAwayWin then
      neededGoal = this.homeGoals
      Some(this.awayScorersList(neededGoal))
    else
      None

  // New in Football3

end Match



