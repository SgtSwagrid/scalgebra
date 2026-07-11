package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedQuotientRing

/**
  * Evidence that any type with a [[scala.math.Integral]] instance forms an
  * [[OrderedQuotientRing]] under standard integer arithmetic.
  */
trait IntegralIsOrderedQuotientRing:

  given [A : Integral as num] => OrderedQuotientRing[A]:

    override def zero: A                  = num.zero
    override def one: A                   = num.one
    override def compare(x: A, y: A): Int = num.compare(x, y)

    extension (x: A)

      override def add(y: A): A = num.plus(x, y)
      override def negate: A    = num.negate(x)
      override def mul(y: A): A = num.times(x, y)
      override def div(y: A): A = num.quot(x, y)
