package com.backwards.two

import scala.language.implicitConversions

trait Reverse[T] {
  def apply(t: T): T
}

object Reverse {
  def apply[T: Reverse](t: T): T = implicitly[Reverse[T]].apply(t)

  trait Ops[T] {
    def reverseIt: T
  }

  object ops {
    implicit def toReverseOps[T: Reverse](t: T): Ops[T] = new Ops[T] {
      def reverseIt: T = apply(t)
    }
  }
}