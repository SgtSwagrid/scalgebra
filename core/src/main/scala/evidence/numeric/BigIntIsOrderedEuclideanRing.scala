package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedEuclideanRing

/**
  * Evidence that [[BigInt]] forms an [[OrderedEuclideanRing]] under
  * arbitrary-precision integer arithmetic.
  */
trait BigIntIsOrderedEuclideanRing:

  given OrderedEuclideanRing[BigInt] with

    override inline def negate(x: BigInt): BigInt              = -x
    override inline def add(x: BigInt, y: BigInt): BigInt      = x + y
    override inline def divide(x: BigInt, y: BigInt): BigInt   = x / y
    override inline def multiply(x: BigInt, y: BigInt): BigInt = x * y
    override def one: BigInt                                   = BigInt(1)
    override def zero: BigInt                                  = BigInt(0)
    override def compare(x: BigInt, y: BigInt): Int            = x.compareTo(y)
