package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedRing

/**
  * Evidence that any type with a [[scala.math.Numeric]] instance forms an
  * [[OrderedRing]] under standard numeric arithmetic.
  */
trait NumericIsOrderedRing:

  given [A : Numeric as num] => OrderedRing[A]:

    override def zero: A                  = num.zero
    override def one: A                   = num.one
    override def compare(x: A, y: A): Int = num.compare(x, y)

    extension (x: A)

      override def add(y: A): A = num.plus(x, y)
      override def negate: A    = num.negate(x)
      override def mul(y: A): A = num.times(x, y)
