package o1.auctionhouse

import scala.collection.mutable.Buffer

class AuctionHouse(val name: String):

  private val items = Buffer[ItemForSale]()
  
  def addItem(item: ItemForSale): Unit =
    this.items += item
    
  def removeItem(item: ItemForSale): Unit =
    this.items -= item
    
  def nextDay(): Unit =
    for current <- this.items do
      current.advanceOneDay()
      
  def totalPrice: Int =
    var totalSoFar = 0
    for current <- this.items do
      totalSoFar += current.price
    totalSoFar
    
  def averagePrice: Double =
    this.totalPrice.toDouble / this.items.size
    
  def numberOfOpenItems: Int =
    var openCount = 0
    for current <- this.items do
      if current.isOpen then
        openCount += 1
    openCount
  
  def priciest: Option[ItemForSale] =
    if this.items.isEmpty then
      None
    else
      var priciestSoFar = this.items.head
      for current <- this.items do
        if current.price > priciestSoFar.price then
          priciestSoFar = current
      Some(priciestSoFar)
      
  def purchasesOf(buyer: String): Vector[ItemForSale] =
    val purchases = Buffer[ItemForSale]()
    for current <- this.items do
      if current.buyer == Some(buyer) then
        purchases += current
    purchases.toVector
  
  override def toString: String = if this.items.nonEmpty then this.name + ":\n" + this.items.mkString("\n") else this.name

end AuctionHouse
