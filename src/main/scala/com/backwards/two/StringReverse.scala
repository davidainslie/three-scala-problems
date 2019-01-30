package com.backwards.two

import com.backwards.one._

object StringReverse {
  implicit val stringReverse: Reverse[String] = s => reverse(s)
}