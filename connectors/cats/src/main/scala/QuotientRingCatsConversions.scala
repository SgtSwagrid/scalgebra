package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversion from [[algebra.ring.EuclideanRing]] to
  * [[scalgebra.arithmetic.QuotientRing]].
  *
  * @note
  *   Only the [[algebra.ring.EuclideanRing]] →
  *   [[scalgebra.arithmetic.QuotientRing]] direction is provided. The reverse
  *   requires a `euclideanFunction`, which has no counterpart in
  *   [[scalgebra.arithmetic.QuotientRing]]. For [[scalgebra.arithmetic.Field]],
  *   see [[FieldCatsConversions]].
  */
trait QuotientRingCatsConversions:

  /**
    * Derives a [[scalgebra.arithmetic.QuotientRing]] from an
    * [[algebra.ring.EuclideanRing]].
    */
  given quotientRingFromCats
    : [X : algebra.ring.EuclideanRing as S]
      => scalgebra.arithmetic.QuotientRing[X]:

    override def zero: X = S.zero
    override def one: X  = S.one

    extension (x: X)

      override def add(y: X): X = S.plus(x, y)
      override def negate: X    = S.negate(x)
      override def mul(y: X): X = S.times(x, y)
      override def div(y: X): X = S.equot(x, y)
