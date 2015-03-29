package fr.scalculator

import org.specs2.mutable


class ScalculatorTest extends mutable.SpecificationWithJUnit with Scalculator {

  "The calculator with no input " should {
    "return no result" in {
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

  "The calculator with : 3+4 " should {
    "return 7" in {
      calculate("3+4") must beSome(7)
    }
  }

  "The calculator" should {
    "ignore space" in {
      calculate("3 + 4") must beSome(7)
    }
  }

  "The calculator with : 9-7 " should {
    "return 2" in {
      calculate("9-7") must beSome(2)
    }
  }

  "The calculator with : 2*4 " should {
    "return 8" in {
      calculate("2*4") must beSome(8)
    }
  }

  "The calculator with : 4/2 " should {
    "return 2" in {
      calculate("4/2") must beSome(2)
    }
  }

  "The calculator with : 3/2 " should {
    "return 1.5" in {
      calculate("" +
        "3/2") must beSome(1.5)
    }
  }


}
