package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as structures

/**
  * Implicit conversion from [[algebra.ring.EuclideanRing]] to
  * [[structures.EuclideanRing]].
  *
  * @note
  *   Only the [[algebra.ring.EuclideanRing]] → [[structures.EuclideanRing]]
  *   direction is provided. The reverse requires a `euclideanFunction`, which
  *   has no counterpart in [[structures.EuclideanRing]]. For
  *   [[structures.Field]], see [[FieldConversions]].
  */
trait EuclideanRingCatsConversions:

  /**
    * Derives a [[structures.EuclideanRing]] from an
    * [[algebra.ring.EuclideanRing]].
    */
  given euclideanRingFromCats[X : algebra.ring.EuclideanRing as S]
    : structures.EuclideanRing[X] with

    def add(x: X, y: X): X      = S.plus(x, y)
    def zero: X                 = S.zero
    def negate(x: X): X         = S.negate(x)
    def multiply(x: X, y: X): X = S.times(x, y)
    def one: X                  = S.one
    def divide(x: X, y: X): X   = S.equot(x, y)
