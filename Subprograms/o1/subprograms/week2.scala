package o1.subprograms
import scala.math.*

import o1.*

// WRITE YOUR OWN FUNCTIONS BELOW. (You may remove the example function.)

def twoByTwo(img: Pic) =
  val a = img.leftOf(img)
  val b = a.above(a)
  b


def flagOfSomalia(w: Double) =
  val base = rectangle(w, 2.0 /3.0 * w, RoyalBlue)
  val wt = w * 4.0 / 13.0
  val s = star(wt, White)
  s.onto(base)


def flagOfFinland(w: Double) =
  val x = w / 18.0
  val smallwhite = rectangle(5*x, 4*x, White)
  val bigwhite = rectangle(10*x, 4*x, White)
  val leftpart = smallwhite.above(rectangle(5*x, 3*x, Blue).above(smallwhite))
  val middlepart = rectangle(3*x, 11*x, Blue)
  val rightpart = bigwhite.above(rectangle(10*x, 3*x, Blue).above(bigwhite))
  leftpart.leftOf(middlepart.leftOf(rightpart))

def clownify(pic1: Pic, position: Pos) = pic1.place(circle(15, Red),position)

def leftSide(o: Pic, p: Double) = o.crop(Pos(0,0), p*0.01*o.width, o.height)

def rightSide(o: Pic, p: Double) = o.crop(Pos(o.width*(1-p*0.01)-1,0), p*0.01*o.width, o.height)

def foldIn(upic: Pic, p: Double) = leftSide(upic,p).leftOf(rightSide(upic,p))

def flagOfCzechia(wflag: Double) =
  val hflag = wflag * 2 / 3.0

  val tri = triangle(hflag, wflag/2.0, MidnightBlue).clockwise(90)
  val back = rectangle(wflag, hflag/2.0, White).above(rectangle(wflag, hflag/2.0, Crimson))
  tri.onto(back, CenterLeft, CenterLeft)
