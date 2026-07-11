package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedQuotientRing

/**
  * Evidence that [[Int]] forms an [[OrderedQuotientRing]] under standard 32-bit
  * integer arithmetic.
  */
trait IntIsOrderedQuotientRing:

  given OrderedQuotientRing[Int]:

    override def zero: Int                    = 0
    override def one: Int                     = 1
    override def compare(x: Int, y: Int): Int = x.compareTo(y)

    extension (x: Int)

      override def add(y: Int): Int = x + y
      override def negate: Int      = -x
      override def mul(y: Int): Int = x * y
      override def div(y: Int): Int = x / y
