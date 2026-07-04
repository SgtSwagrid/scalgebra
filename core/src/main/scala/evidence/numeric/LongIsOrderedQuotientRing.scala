package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedQuotientRing

/**
  * Evidence that [[Long]] forms an [[OrderedQuotientRing]] under standard
  * 64-bit integer arithmetic.
  */
trait LongIsOrderedQuotientRing:

  given OrderedQuotientRing[Long]:

    override def zero: Long                     = 0L
    override def one: Long                      = 1L
    override def compare(x: Long, y: Long): Int = x.compareTo(y)

    extension (x: Long)

      override def add(y: Long): Long = x + y
      override def negate: Long       = -x
      override def mul(y: Long): Long = x * y
      override def div(y: Long): Long = x / y
