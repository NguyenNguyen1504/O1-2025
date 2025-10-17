package o1.odds
import scala.util.Random
// This class is developed gradually between Chapters 2.4 and 3.4.

class Odds(val wont: Int, val will: Int):

  def probability = 1.0 * this.will / (this.wont + this.will)
  def fractional = s"${this.wont}/${this.will}"
  def decimal = 1.0 / probability
  def winnings(bet: Double) = bet * decimal *1.0
  def not = Odds(this.will,this.wont)

  override def toString = fractional

  def both(another: Odds) =
    val a1 = this.wont
    val a2 = this.will
    val b1 = another.wont
    val b2 = another.will
    val bothNumerator = a1*b1 + a1*b2 + a2*b1
    val bothDenominator = a2*b2
    Odds(bothNumerator, bothDenominator)
  def either(another: Odds) =
    val a1 = this.wont
    val a2 = this.will
    val b1 = another.wont
    val b2 = another.will
    val eitherNumerator = a1*b1
    val eitherDenominator = a1*b2 + a2*b1 + a2*b2
    Odds(eitherNumerator, eitherDenominator)

  def isLikely = this.will > this.wont
  def isLikelierThan(another: Odds) = this.probability > another.probability

  def moneyline =
    if this.probability <= 0.5 then
      100 * this.wont / this.will
    else
      -100 * this.will / this.wont

  def eventHappens() =
    val r = Random.nextInt(this.wont + this.will)
    r < this.will

end Odds


