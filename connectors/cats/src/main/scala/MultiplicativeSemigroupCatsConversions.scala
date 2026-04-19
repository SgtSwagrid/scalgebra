package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as structures

/**
  * Implicit conversions between [[structures.MultiplicativeSemigroup]] and
  * [[algebra.ring.MultiplicativeSemigroup]].
  */
trait MultiplicativeSemigroupCatsConversions:

  /**
    * Derives an [[algebra.ring.MultiplicativeSemigroup]] from a
    * [[structures.MultiplicativeSemigroup]].
    */
  given multiplicativeSemigroupToCats[
    X : structures.MultiplicativeSemigroup as S,
  ]: algebra.ring.MultiplicativeSemigroup[X] with
    def times(x: X, y: X): X = S.multiply(x, y)

  /**
    * Derives a [[structures.MultiplicativeSemigroup]] from an
    * [[algebra.ring.MultiplicativeSemigroup]].
    */
  given multiplicativeSemigroupFromCats[
    X : algebra.ring.MultiplicativeSemigroup as S,
  ]: structures.MultiplicativeSemigroup[X] with
    def multiply(x: X, y: X): X = S.times(x, y)
