package com.backwards.three

import scala.reflect.runtime.universe._
import org.scalatest.{MustMatchers, WordSpec}

class TypeErasureSpec extends WordSpec with MustMatchers {
  "Type erasure" should {
    "have a workaround in Scala" in {
      def example[T: TypeTag](seq: Seq[T]): Class[_] = seq match {
        case _: Seq[String @unchecked] if typeOf[T] =:= typeOf[String] => classOf[String]
        case _: Seq[Int @unchecked] if typeOf[T] =:= typeOf[Int] => classOf[Int]
      }

      example(Seq("blah")) mustEqual classOf[String]
      example(Seq(4)) mustEqual classOf[Int]
    }
  }
}