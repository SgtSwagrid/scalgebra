package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedQuotientRing

/**
  * Evidence that [[Short]] forms an [[OrderedQuotientRing]] under standard
  * 16-bit integer arithmetic.
  */
trait ShortIsOrderedQuotientRing:

  given OrderedQuotientRing[Short]:

    override def zero: Short                      = 0
    override def one: Short                       = 1
    override def compare(x: Short, y: Short): Int = x.compareTo(y)

    extension (x: Short)

      override def add(y: Short): Short = (x + y).toShort
      override def negate: Short        = (-x).toShort
      override def mul(y: Short): Short = (x * y).toShort
      override def div(y: Short): Short = (x / y).toShort
