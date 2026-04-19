package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.{scalgebra as structures}

/**
  * Implicit conversions between [[structures.AdditiveMonoid]] and
  * [[algebra.ring.AdditiveMonoid]].
  */
trait AdditiveMonoidCatsConversions:

  /**
    * Derives an [[algebra.ring.AdditiveMonoid]] from an
    * [[structures.AdditiveMonoid]].
    */
  given additiveMonoidToCats[X : structures.AdditiveMonoid as S]
    : algebra.ring.AdditiveMonoid[X] with

    def plus(x: X, y: X): X = S.add(x, y)
    def zero: X             = S.zero

  /**
    * Derives an [[structures.AdditiveMonoid]] from an
    * [[algebra.ring.AdditiveMonoid]].
    */
  given additiveMonoidFromCats[X : algebra.ring.AdditiveMonoid as S]
    : structures.AdditiveMonoid[X] with

    def add(x: X, y: X): X = S.plus(x, y)
    def zero: X            = S.zero
