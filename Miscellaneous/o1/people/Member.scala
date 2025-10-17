package o1.people

class Member(val id: Int, val name: String, val yearOfBirth: Int, val yearOfDeath: Option[Int]):

  def isAlive = this.yearOfDeath.isEmpty
  override def toString =
    val end = yearOfDeath.getOrElse("")
    s"${this.name}(${this.yearOfBirth}-$end)"
  // TODO: missing methods

end Member
