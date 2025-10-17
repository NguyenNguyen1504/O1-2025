package o1.people

class Passenger(val name: String, val card: Option[TravelCard]):

  def canTravel =
    this.card match
      case Some(card) => card.isValid
      case None => false

  def hasCard = this.card.isDefined


end Passenger
