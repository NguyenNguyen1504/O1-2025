package o1.legal


// TODO: define JuridicalPerson, HumanOrganization, GeographicalFeature, and Group.
trait JuridicalPerson extends Entity

trait HumanOrganization(val contact: NaturalPerson) extends JuridicalPerson

class GeographicalFeature(name: String, val kind: String, val representative: Entity) extends Entity(name), JuridicalPerson:
  def contact = this.representative.contact

class Group(val members: Vector[Entity]) extends Entity("group"), JuridicalPerson:
  val leader = this.members.head
  def kind = s"group of ${this.members.size} led by ${this.leader.name}"
  def contact = this.leader.contact





// TODO: uncomment the classes below


class Nation(name: String, contact: NaturalPerson) extends Entity(name), HumanOrganization(contact):
  def kind = "sovereign nation"

class Municipality(name: String, val nation: Nation, contact: NaturalPerson)
      extends Entity(name), HumanOrganization(contact):
  def kind = "municipality of " + this.nation.name


class Corporation(val id: String, val seeksProfit: Boolean, name: String, contact: NaturalPerson)
      extends Entity(name), HumanOrganization(contact):
  def kind = (if this.seeksProfit then "for-" else "non-") + "profit corporation"


