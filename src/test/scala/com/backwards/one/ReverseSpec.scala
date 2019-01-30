package com.backwards.one

import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.prop.PropertyChecks
import org.scalatest.{MustMatchers, PropSpec}

class ReverseSpec extends PropSpec with PropertyChecks with MustMatchers {
  implicit override val generatorDrivenConfig: PropertyCheckConfiguration =
    PropertyCheckConfig(minSuccessful = 100)

  property("Alpha String must be reversed") {
    implicit val stringArbitrary: Arbitrary[String] = Arbitrary(Gen.alphaStr)

    forAll { s: String =>
      reverse(reverse(s)) mustEqual s
    }
  }

  property("Any kind of String must be reversed") {
    forAll { s: String =>
      reverse(reverse(s)) mustEqual s
    }
  }
}