package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedQuotientRing

/**
  * Evidence that [[BigInt]] forms an [[OrderedQuotientRing]] under
  * arbitrary-precision integer arithmetic.
  */
trait BigIntIsOrderedQuotientRing:

  given OrderedQuotientRing[BigInt]:

    override def zero: BigInt                       = BigInt(0)
    override def one: BigInt                        = BigInt(1)
    override def compare(x: BigInt, y: BigInt): Int = x.compareTo(y)

    extension (x: BigInt)

      override def add(y: BigInt): BigInt = x + y
      override def negate: BigInt         = -x
      override def mul(y: BigInt): BigInt = x * y
      override def div(y: BigInt): BigInt = x / y
