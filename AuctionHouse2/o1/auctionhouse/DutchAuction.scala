package o1.auctionhouse

import scala.math.max

class DutchAuction(description: String, val startingPrice: Int, val decrement: Int, val minimumPrice: Int) extends ItemForSale(description), InstantPurchase:
  
  private var remainingDays = 5
  private var currentPrice = this.startingPrice
  
  def advanceOneDay() =
    if this.isOpen then
      this.currentPrice = max(this.currentPrice - this.decrement, this.minimumPrice)
      if this.currentPrice == this.minimumPrice then this.remainingDays -= 1

  def isExpired = this.remainingDays <= 0
  
  def price = this.currentPrice

  def priceRatio = this.currentPrice * 1.0 / this.startingPrice
  
end DutchAuction



