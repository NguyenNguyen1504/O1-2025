package o1.legal



// TODO: define NaturalPerson, FullCapacityPerson, and ReducedCapacityPerson
trait NaturalPerson(val personID: String) extends Entity:
  def kind = "human"
end NaturalPerson

class FullCapacityPerson(personID: String, name: String) extends Entity(name), NaturalPerson(personID):
  def contact = this
  override def kind = super.kind + " in full capacity"

class ReducedCapacityPerson(personID: String, name: String, val restriction: Restriction, val guardian: FullCapacityPerson) extends Entity(name), NaturalPerson(personID):
  def contact = this.guardian.contact
  override def kind = super.kind + " with " + this.restriction