package fr.scalculator

trait Scalculator {
  def calculate(expression : String) : Option[Int] = {
    toInt(expression)
  }


  def toInt(s: String):Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case e:Exception => None
    }
  }
}
