package o1.time

class Interval(val start: Moment, val end: Moment):

  def contains(moment: Moment): Boolean = moment.isIn(this)

  def contains(another: Interval): Boolean = this.contains(another.start) && this.contains(another.end)

  def isLaterThan(moment: Moment) = this.start.isLaterThan(moment)

  def isLaterThan(another: Interval) = this.start.isLaterThan(another.end)

  def length = this.start.distance(this.end)

  override def toString =
    if this.length == 0 then
      this.start.toString
    else if this.length > 50 then
      this.start.toString + "..." + this.end.toString
    else
      this.start.toString + "-" * this.length + this.end.toString

  def intersection(another: Interval): Option[Interval] =
    val newStart = this.start.later(another.start)
    val newEnd = this.end.earlier(another.end)
    if newStart.isLaterThan(newEnd) then
      None
    else
      Some(Interval(newStart,newEnd))

  def union(another: Interval) =
    val newStart = this.start.earlier(another.start)
    val newEnd = this.end.later(another.end)
    Interval(newStart,newEnd)

  def overlaps(another: Interval) = this.intersection(another).isDefined


end Interval

