package o1.auctionhouse
import scala.math.max

class DutchAuction(val description: String, val startingPrice: Int, val decrement: Int, val minimumPrice: Int):

  private var remainingDays = 5
  private var currentPrice = this.startingPrice
  private var buyerInfo: Option[String] = None

  def advanceOneDay() =
    if this.isOpen then
      this.currentPrice = max(this.currentPrice - this.decrement, this.minimumPrice)
      if this.currentPrice == this.minimumPrice then this.remainingDays -= 1

  def buy(buyer: String) =
    if this.isOpen then
      this.buyerInfo = Some(buyer)
      true
    else
      false

  def buyer = this.buyerInfo

  def isExpired = this.remainingDays <= 0

  def isOpen = !this.isExpired && this.buyerInfo.isEmpty

  override def toString = this.description

  def price = this.currentPrice

  def priceRatio = this.currentPrice * 1.0 / this.startingPrice

end DutchAuction