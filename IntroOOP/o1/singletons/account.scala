// At this stage, you don’t have to worry about the definitions immediately below this text.
package o1.singletons

import scala.math.*


class Account(val number: String):

  var balance = 0

  def deposit(d: Int) =
    this.balance = max(this.balance, this.balance + d)
  def withdraw(w: Int) =
    val realw = min(this.balance, w)
    this.balance -= realw
    realw

end Account

