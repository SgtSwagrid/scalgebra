package com.alecdorrington.scalgebra
package ordered

import scala.annotation.targetName

/** An ordered version of [[Ring]]. */
trait OrderedRing[X]
  extends Ring[X], OrderedPseudoring[X], OrderedDifferenceSemiring[X]:

  /**
    * Computes the sign of a value [[x]], represented by [[one]] for positive,
    * [[negativeOne]] for negative, or [[zero]] for itself.
    */
  inline def sign(x: X): X =
    if lt(x, zero) then negativeOne else if gt(x, zero) then one else zero

  extension (x: X)

    /**
      * Computes the sign of [[x]], represented by [[one]] for positive,
      * [[negativeOne]] for negative, or [[zero]] for itself.
      */
    @targetName("sign_postfix")
    inline def sign: X = OrderedRing.this.sign(x)

/** The companion object for [[OrderedRing]]. */
object OrderedRing extends OrderedRing.Ops:

  trait Ops
    extends Ring.Ops, OrderedPseudoring.Ops, OrderedDifferenceSemiring.Ops:

    /**
      * Computes the sign of a value [[x]], represented by [[one]] for positive,
      * [[negativeOne]] for negative, or [[zero]] for itself.
      */
    inline def sign[X : OrderedRing as X](x: X): X = X.sign(x)

  export com.alecdorrington.scalgebra.ordered.OrderedRing

  /** The [[OrderedRing]] instance describing the current algebra system. */
  inline def orderedRing[X : OrderedRing as orderedRing]: OrderedRing[X] =
    orderedRing
