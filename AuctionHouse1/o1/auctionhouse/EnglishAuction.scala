package o1.auctionhouse

import scala.math.*

class EnglishAuction(val description: String, val startingPrice: Int, duration: Int):

  private var highestBid = Bid(None, startingPrice)
  private var secondHighestBid = Bid(None, startingPrice)
  private var remainingDays = duration

  def daysLeft = this.remainingDays

  def advanceOneDay() =
    if this.isOpen then
      this.remainingDays -= 1

  def isOpen = this.remainingDays > 0

  def hasNoBids = this.highestBid.isInitialBid

  def isExpired = !this.isOpen && this.hasNoBids

  def buyer = this.highestBid.bidder

  def price =
    if this.secondHighestBid.isInitialBid then
      this.startingPrice
    else
      min(this.secondHighestBid.limit + 1, this.highestBid.limit)

  def requiredBid = if this.hasNoBids then this.startingPrice else this.price + 1

  def bid(bidder: String, amount: Int) =
    val newBid = Bid(Some(bidder), amount)
    if this.isOpen && amount >= this.requiredBid then
      this.secondHighestBid = if newBid.beats(this.highestBid) then this.highestBid
                              else newBid.winner(this.secondHighestBid)
      this.highestBid = newBid.winner(this.highestBid)
    end if
    this.highestBid == newBid

  override def toString = this.description

end EnglishAuction