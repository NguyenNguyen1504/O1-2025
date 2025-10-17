package o1.classes

// This class is introduced in Chapter 2.6.

class Order(val number: Int, val orderer: Customer, val address: Option[String]):

  var totalPrice = 0.0   // gatherer
  var isExpress = false

  def addProduct(pricePerUnit: Double, numberOfUnits: Int) =
    this.totalPrice = this.totalPrice + pricePerUnit * numberOfUnits

  override def toString =
    val end =
      this.address match
        case Some(where) => s"deliver to $where"
        case None => "deliver to customer's address"
    "order " + this.number + ", ordered by " + this.orderer + ", total " + this.totalPrice + " euro" + ", " + end

  def deliveryAddress =
    this.address match
      case Some(where) => where
      case None => this.orderer.address

end Order

