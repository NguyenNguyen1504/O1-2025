package o1.auctionhouse

class FixedPriceSale(val description: String, val price: Int, duration: Int):

  private var remainingDays = this.duration
  private var buyerInfo: Option[String] = None

  def advanceOneDay() = if this.isOpen then this.remainingDays -= 1

  def buy(buyer: String) =
    if this.isOpen then
      this.buyerInfo = Some(buyer)
      true
    else
      false

  def buyer = this.buyerInfo

  def daysLeft = this.remainingDays

  def isExpired = this.remainingDays <= 0

  def isOpen = !this.isExpired && this.buyerInfo.isEmpty

  override def toString = this.description


end FixedPriceSale
