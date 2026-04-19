package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as structures

/**
  * Implicit conversions between [[structures.MultiplicativeMonoid]] and
  * [[algebra.ring.MultiplicativeMonoid]].
  */
trait MultiplicativeMonoidCatsConversions:

  /**
    * Derives an [[algebra.ring.MultiplicativeMonoid]] from a
    * [[structures.MultiplicativeMonoid]].
    */
  given multiplicativeMonoidToCats[X : structures.MultiplicativeMonoid as S]
    : algebra.ring.MultiplicativeMonoid[X] with

    def times(x: X, y: X): X = S.multiply(x, y)
    def one: X               = S.one

  /**
    * Derives a [[structures.MultiplicativeMonoid]] from an
    * [[algebra.ring.MultiplicativeMonoid]].
    */
  given multiplicativeMonoidFromCats[X : algebra.ring.MultiplicativeMonoid as S]
    : structures.MultiplicativeMonoid[X] with

    def multiply(x: X, y: X): X = S.times(x, y)
    def one: X                  = S.one
