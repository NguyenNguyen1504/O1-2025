package o1.people

import scala.collection.mutable.Map

// This class is introduced in Chapter 9.2. You can ignore it until then.

class Society(val name: String):

  private val members = Map[Int, Member]()

  def add(newMember: Member): Unit =
    this.members(newMember.id) = newMember

  def getByID(memberID: Int): Option[Member] = 
    this.members.get(memberID)

  def yearOfDeath(memberID: Int): Option[Int] =
    val yodList = this.members.map( (id, member) => (id, member.yearOfDeath) )
    yodList.getOrElse(memberID, None)
  // TODO: add yearOfDeath as instructed in Chapter 9.2.

end Society
