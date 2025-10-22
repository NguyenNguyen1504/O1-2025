package o1.items

import scala.collection.mutable.Buffer

// TODO: Complete this as instructed in Chapter 7.5.

class Container(name: String) extends Item(name):

  private val itemsInside = Buffer[Item]()

  def addContent(newContent: Item): Unit =
    this.itemsInside += newContent

  def contents: Vector[Item] = this.itemsInside.toVector

  override def toString: String = s"${this.name} containing ${this.itemsInside.size} item(s)"


end Container

