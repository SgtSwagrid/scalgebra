package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedSemifield

/**
  * Evidence that [[Boolean]] forms an [[OrderedSemifield]], with `OR` as
  * addition and `AND` as multiplication.
  *
  * This is the Boolean semifield `𝔹`, not the two-element field `GF(2)`: under
  * `OR`, `true` has no additive inverse, so no negation or subtraction is
  * available. Consequently, `x + x == x` and `xs.sumOrZero` computes whether
  * any element is `true`.
  *
  * @note
  *   [[reciprocal]] is the identity on `true` and throws for `false`, in line
  *   with division by [[zero]] elsewhere.
  */
trait BooleanIsOrderedSemifield:

  given OrderedSemifield[Boolean]:

    override def zero: Boolean                        = false
    override def one: Boolean                         = true
    override def compare(x: Boolean, y: Boolean): Int = x.compareTo(y)

    extension (x: Boolean)

      override def add(y: Boolean): Boolean = x | y
      override def mul(y: Boolean): Boolean = x & y

      override def reciprocal: Boolean =
        if x then x else throw ArithmeticException("Division by zero.")
