package o1.subprograms

import o1.*
import scala.math.*
// WRITE YOUR OWN FUNCTIONS HERE, BELOW THE IMPORT COMMAND:
def toMeters(feet: Double, inches: Double) = (feet*12+inches)*0.0254

def volumeOfCube(x: Double) = x*x*x

def areaOfCube(x: Double) = 6*x*x

def row(square: Int) = (square / 8)

def column(square: Int) = (square % 8)

def accompany(text1: String, sound1: String) =
  println(text1)
  play(sound1)

def verticalBar(w: Int, c: Color) = rectangle(w, 10*w, c)

def overallGrade(prj: Int, exam: Int, attend: Int) = min(prj+exam+attend,5)

def leaguePoints(wins: Int, draws: Int) = wins*3 + draws

def teamStats(name: String, wins: Int, draws: Int, losses: Int) =
  val total = wins + draws + losses
  val points = leaguePoints(wins, draws)
  s"$name: $wins/$total wins, $draws/$total draws, $losses/$total losses, $points points"

def verbalEvaluation(projectGrade: Int, examBonus: Int, participationBonus: Int) =
  val descriptions = Buffer("failed", "acceptable", "satisfactory", "good", "very good", "excellent")
  val grade = overallGrade(projectGrade, examBonus, participationBonus)
  descriptions(grade)

def doubleScore(scorelist: Buffer[Int],player: Int) =
  scorelist(player-1) = scorelist(player-1) * 2

def penalize(scorelist: Buffer[Int], player: Int, penalty: Int) =
  val p = player - 1
  val subtraction = min(scorelist(p) - 1, penalty)
  scorelist(p) = max(1, scorelist(p) - subtraction)
  subtraction

def toInches(meters: Double) = meters * 100 / 2.54
def wholeFeet(meters: Double) = (toInches(meters) - toInches(meters) % 12) / 12
def remainingInches(meters: Double) = toInches(meters) % 12

def toFeetAndInches(meters: Double) = (wholeFeet(meters), remainingInches(meters))

// Here is a buggy piece of code for you to fix in one of Chapter 1.7’s assignments.
def onTwoInstruments(melody: String, first: Int, second: Int, lengthOfPause: Int) =
  val melodyUsingFirst  = "[" + first  + "]" + melody
  val melodyUsingSecond = "[" + second + "]" + melody
  val pause = " " * lengthOfPause
  val playedTwice = melodyUsingFirst + pause + melodyUsingSecond
  playedTwice

