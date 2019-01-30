package com.backwards.two

import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.prop.PropertyChecks
import org.scalatest.{MustMatchers, PropSpec}
import com.backwards.two.Reverse.ops._
import com.backwards.two.StringReverse._

class TypeClassReverseSpec extends PropSpec with PropertyChecks with MustMatchers {
  implicit override val generatorDrivenConfig: PropertyCheckConfiguration =
    PropertyCheckConfig(minSuccessful = 100)

  property("Alpha String must be reversed") {
    implicit val stringArbitrary: Arbitrary[String] = Arbitrary(Gen.alphaStr)

    forAll { s: String =>
      s.reverseIt.reverseIt mustEqual s
    }
  }

  property("Any kind of String must be reversed") {
    forAll { s: String =>
      s.reverseIt.reverseIt mustEqual s
    }
  }
}