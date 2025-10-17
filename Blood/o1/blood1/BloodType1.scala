package o1.blood1

class BloodType(val abo: String, val rhesus: Boolean):

  val rhesusSymbol = if rhesus then "+" else "-"

  override def toString = this.abo + this.rhesusSymbol

  def hasSafeABOFor(recipient: BloodType) =
    val case1 = this.abo == "A" && (recipient.abo == "A" || recipient.abo == "AB")
    val case2 = this.abo == "B" && (recipient.abo == "B" || recipient.abo == "AB")
    val case3 = this.abo == "O"
    val case4 = this.abo == "AB" && recipient.abo == "AB"
    case1 || case2 || case3 || case4


  def hasSafeRhesusFor(recipient: BloodType) =
    val case1 = !this.rhesus
    val case2 = this.rhesus && recipient.rhesus
    case1 || case2

  def canDonateTo(recipient: BloodType) = this.hasSafeABOFor(recipient) && this.hasSafeRhesusFor(recipient)

  def canReceiveFrom(donor: BloodType) = donor.canDonateTo(this)

end BloodType

