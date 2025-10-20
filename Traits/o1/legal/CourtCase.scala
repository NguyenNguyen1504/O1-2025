package o1.legal

// TODO: define class CourtCase properly
class CourtCase(val plaintiff: Entity, val defendant: Entity):

  override def toString = s"${this.plaintiff.name} v. ${this.defendant.name}"

end CourtCase
