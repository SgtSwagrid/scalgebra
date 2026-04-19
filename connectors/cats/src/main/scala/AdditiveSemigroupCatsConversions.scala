package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as structures

/**
  * Implicit conversions between [[structures.AdditiveSemigroup]] and
  * [[algebra.ring.AdditiveSemigroup]].
  */
trait AdditiveSemigroupCatsConversions:

  /**
    * Derives an [[algebra.ring.AdditiveSemigroup]] from an
    * [[structures.AdditiveSemigroup]].
    */
  given additiveSemigroupToCats[X : structures.AdditiveSemigroup as S]
    : algebra.ring.AdditiveSemigroup[X] with
    def plus(x: X, y: X): X = S.add(x, y)

  /**
    * Derives an [[structures.AdditiveSemigroup]] from an
    * [[algebra.ring.AdditiveSemigroup]].
    */
  given additiveSemigroupFromCats[X : algebra.ring.AdditiveSemigroup as S]
    : structures.AdditiveSemigroup[X] with
    def add(x: X, y: X): X = S.plus(x, y)
