package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.Ring
import com.alecdorrington.scalgebra.ordered.builder.OrderedRingBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedRingOps

/** An ordered version of [[Ring]]. */
trait OrderedRing[X]
  extends Ring[X], OrderedAdditiveGroup[X], OrderedDifferenceSemiring[X]:

  /**
    * Computes the sign of a value [[x]], represented by [[one]] for positive,
    * [[negativeOne]] for negative, or [[zero]] for itself.
    */
  final inline def sign(x: X): X =
    if isNegative(x) then negativeOne else if isPositive(x) then one else zero

/**
  * The companion object for [[OrderedRing]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedRing.{*, given}
  * ```
  * to receive all necessary syntax for working with ordered rings.
  */
object OrderedRing extends OrderedRingBuilder, OrderedRingOps:

  export com.alecdorrington.scalgebra.ordered.OrderedRing

  /** The [[OrderedRing]] instance describing the current algebra system. */
  inline def orderedRing[X : OrderedRing as orderedRing]: OrderedRing[X] =
    orderedRing
