package fr.scalculator

trait Scalculator {
  def calculate(expression: String): Option[Float] = {
    if (expression.contains('+')) {
      val result = splitExpression(expression, '+')
      Some(result._1 + result._2)
    } else if (expression.contains('-')) {
      val result = splitExpression(expression, '-')
      Some(result._1 - result._2)
    } else if (expression.contains('*')) {
      val result = splitExpression(expression, '*')
      Some(result._1 * result._2)
    } else if (expression.contains('/')) {
      val result = splitExpression(expression, '/')
      Some(result._1 / result._2)
    }
    else {
      toFloat(expression)
    }

  }


  private def splitExpression(expression: String, sign: Char) = {
    val signIndex = expression.indexOf(sign)
    val firstExpression = expression.substring(0, signIndex)
    val secondExpression = expression.substring(signIndex + 1, expression.size)
    (calculate(firstExpression).get, calculate(secondExpression).get)
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
