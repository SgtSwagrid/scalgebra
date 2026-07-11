package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedQuotientRing

/**
  * Evidence that [[Byte]] forms an [[OrderedQuotientRing]] under standard 8-bit
  * integer arithmetic.
  */
trait ByteIsOrderedQuotientRing:

  given OrderedQuotientRing[Byte]:

    override def zero: Byte                     = 0
    override def one: Byte                      = 1
    override def compare(x: Byte, y: Byte): Int = x.compareTo(y)

    extension (x: Byte)

      override def add(y: Byte): Byte = (x + y).toByte
      override def negate: Byte       = (-x).toByte
      override def mul(y: Byte): Byte = (x * y).toByte
      override def div(y: Byte): Byte = (x / y).toByte
