package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversion from [[spire.algebra.EuclideanRing]] to
  * [[scalgebra.arithmetic.QuotientRing]].
  *
  * @note
  *   Only the [[spire.algebra.EuclideanRing]] →
  *   [[scalgebra.arithmetic.QuotientRing]] direction is provided. The reverse
  *   requires a `euclideanFunction`, which has no counterpart in
  *   [[scalgebra.arithmetic.QuotientRing]]. For [[scalgebra.arithmetic.Field]],
  *   see [[FieldSpireConversions]].
  */
trait QuotientRingSpireConversions:

  /**
    * Derives a [[scalgebra.arithmetic.QuotientRing]] from a
    * [[spire.algebra.EuclideanRing]].
    */
  given quotientRingFromSpire
    : [X : algebra.EuclideanRing as S] => scalgebra.arithmetic.QuotientRing[X]:

    override def zero: X = S.zero
    override def one: X  = S.one

    extension (x: X)

      override def add(y: X): X = S.plus(x, y)
      override def negate: X    = S.negate(x)
      override def mul(y: X): X = S.times(x, y)
      override def div(y: X): X = S.equot(x, y)
