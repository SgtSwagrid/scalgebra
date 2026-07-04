package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.AdditiveMonoid]] and
  * [[algebra.ring.AdditiveMonoid]].
  */
trait AdditiveMonoidCatsConversions:

  /**
    * Derives an [[algebra.ring.AdditiveMonoid]] from an
    * [[scalgebra.arithmetic.AdditiveMonoid]].
    */
  given additiveMonoidToCats
    : [X : scalgebra.arithmetic.AdditiveMonoid as S]
      => algebra.ring.AdditiveMonoid[X]:

    def plus(x: X, y: X): X = x + y
    def zero: X             = S.zero

  /**
    * Derives an [[scalgebra.arithmetic.AdditiveMonoid]] from an
    * [[algebra.ring.AdditiveMonoid]].
    */
  given additiveMonoidFromCats
    : [X : algebra.ring.AdditiveMonoid as S]
      => scalgebra.arithmetic.AdditiveMonoid[X]:

    override def zero: X                       = S.zero
    extension (x: X) override def add(y: X): X = S.plus(x, y)
