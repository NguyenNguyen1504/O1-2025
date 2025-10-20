package o1.auctionhouse

class FixedPriceSale(description: String, val price: Int, duration: Int) extends ItemForSale(description), InstantPurchase:
  
  private var remainingDays = this.duration
  
  def advanceOneDay() = if this.isOpen then this.remainingDays -= 1
  
  def daysLeft = this.remainingDays

  def isExpired = this.remainingDays <= 0
  
end FixedPriceSale
  
