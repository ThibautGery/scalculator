package fr.scalculator

trait Scalculator {

  def add(right: Float, left: Float): Float = {
    right + left
  }

  def substract(right: Float, left: Float): Float = {
    right - left
  }

  def multiply(right: Float, left: Float): Float = {
    right * left
  }

  def division(right: Float, left: Float): Float = {
    right / left
  }

  def calculate(expression: String): Option[Float] = {
    if (expression.contains('+')) {
      interpretExpression(expression, '+', add)
    } else if (expression.contains('-')) {
      interpretExpression(expression, '-', substract)
    } else if (expression.contains('*')) {
      interpretExpression(expression, '*', multiply)
    } else if (expression.contains('/')) {
      interpretExpression(expression, '/', division)
    }
    else {
      toFloat(expression)
    }

  }

  private def interpretExpression(expression: String, sign: Char, operation: (Float, Float) => Float): Option[Float] = {
    val signIndex = expression.indexOf(sign)
    val firstExpression = expression.substring(0, signIndex)
    val secondExpression = expression.substring(signIndex + 1, expression.size)

    for (f0 <- calculate(firstExpression);
         s0 <- calculate(secondExpression)) yield operation(f0, s0)
  }

  private def toFloat(s: String): Option[Float] = {
    try {
      Some(s.toFloat)
    } catch {
      case e: Exception => None
    }
  }
}

object Main extends Scalculator {
  def main(args: Array[String]) = {
    print("result : " + calculate(args(0)) + "\n")
  }
}
