package o1.misc
import o1.*

// Various small assignments across several chapters ask you to define functions in this file.





def isPortrait(pic: Pic) = pic.height > pic.width

def describe(pic: Pic) =
  if isPortrait(pic) then
    "portrait"
  else if pic.height == pic.width then
    "square"
  else
    "landscape"

def together(voices: Vector[String], tempo: Int) =
  voices.mkString("&")+s"/$tempo"

def insert(added: String, target: String, index: Int) =
  if index <= 0 then
    added + target
  else if index >= target.length then
    target + added
  else
    target.substring(0, index) + added + target.drop(index)

def tempo(text: String) =
  text.drop(text.indexOf("/") + 1).toIntOption match
    case Some(n) => n
    case None => 120
