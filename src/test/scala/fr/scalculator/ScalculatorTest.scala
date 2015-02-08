package fr.scalculator

import org.specs2.mutable


class ScalculatorTest extends mutable.SpecificationWithJUnit with Scalculator{

  "The calculator with no input " should {
      "return no result" in {
        calculate(null) must beNone
        calculate("") must beNone
      }
    }

  "The calculator with : 1 " should {
    "return 1" in {
      calculate("1") must beSome(1)
    }
  }

  "The calculator with : 2 " should {
    "return 2" in {
      calculate("2") must beSome(2)
    }
  }


}
