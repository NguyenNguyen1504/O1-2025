package o1.auctionhouse
import scala.collection.mutable.Buffer

class AuctionTest(val name: String):

  private val items = Buffer[EnglishAuction]()
  private var priceSoFar = 0

  def addItem(item: EnglishAuction) =
    this.items += item
    this.priceSoFar += item.price

  def removeItem(item: EnglishAuction) =
    this.items -= item
    this.priceSoFar -= item.price

  def totalPrice = this.priceSoFar

end AuctionTest

