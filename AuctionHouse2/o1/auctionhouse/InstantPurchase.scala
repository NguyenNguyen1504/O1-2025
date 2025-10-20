package o1.auctionhouse

trait InstantPurchase extends ItemForSale:
  
  private var buyerInfo: Option[String] = None
  
  def buy(buyer: String) =
    if this.isOpen then
      this.buyerInfo = Some(buyer)
      true
    else
      false

  def buyer = this.buyerInfo
  
  def isOpen = !this.isExpired && this.buyerInfo.isEmpty
  
end InstantPurchase


