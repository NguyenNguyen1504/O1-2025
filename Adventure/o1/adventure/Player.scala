package o1.adventure

import scala.collection.mutable.Map

/** A `Player` object represents a player character controlled by the real-life user
  * of the program.
  *
  * A player object’s state is mutable: the player’s location and possessions can change,
  * for instance.
  *
  * @param startingArea  the player’s initial location */
class Player(startingArea: Area):

  private var currentLocation = startingArea        // gatherer: changes in relation to the previous location
  private var quitCommandGiven = false              // one-way flag
  private val itemsContainer = Map[String, Item]()


  def has(itemName: String): Boolean =
    this.itemsContainer.contains(itemName)

  def inventory: String =
    if itemsContainer.isEmpty then
      "You are empty-handed."
    else
      val itemList = this.itemsContainer.keys.mkString("\n")
      s"You are carrying:\n$itemList"

  def get(itemName: String): String =
    this.location.removeItem(itemName) match
      case Some(item) =>
        this.itemsContainer(itemName) = item
        this.location.removeItem(itemName)
        s"You pick up the $itemName."
      case None => s"There is no $itemName here to pick up."

  def drop(itemName: String): String =
    if this.has(itemName) then
      val itemToRemove = this.itemsContainer(itemName)
      this.itemsContainer -= itemName
      this.location.addItem(itemToRemove)
      s"You drop the $itemName."
    else
      "You don't have that!"

  def examine(itemName: String): String =
    if this.has(itemName) then
      val itemToExamine = this.itemsContainer(itemName)
      s"You look closely at the $itemName.\n${itemToExamine.description}"
    else
      "If you want to examine something, you need to pick it up first."

  /** Determines if the player has indicated a desire to quit the game. */
  def hasQuit = this.quitCommandGiven

  /** Returns the player’s current location. */
  def location = this.currentLocation


  /** Attempts to move the player in the given direction. This is successful if there
    * is an exit from the player’s current location towards the direction name. Returns
    * a description of the result: "You go DIRECTION." or "You can't go DIRECTION." */
  def go(direction: String) =
    val destination = this.location.neighbor(direction)
    this.currentLocation = destination.getOrElse(this.currentLocation)
    if destination.isDefined then s"You go $direction." else s"You can't go $direction."


  /** Causes the player to rest for a short while (this has no substantial effect in game terms).
    * Returns a description of what happened. */
  def rest() = "You rest for a while. Better get a move on, though."


  /** Signals that the player wants to quit the game. Returns a description of what happened
    * within the game as a result (which is the empty string, in this case). */
  def quit() =
    this.quitCommandGiven = true
    ""


  /** Returns a brief description of the player’s state, for debugging purposes. */
  override def toString = "Now at: " + this.location.name

end Player

