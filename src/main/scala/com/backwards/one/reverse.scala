package com.backwards.one

object reverse {
  def apply(s: String): String =
    ("" /: s)((acc, x) => x + acc)
}