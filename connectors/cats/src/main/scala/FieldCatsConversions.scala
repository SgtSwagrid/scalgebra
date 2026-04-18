package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra

/**
  * Implicit conversions between [[structures.Field]] and
  * [[algebra.ring.Field]].
  *
  * @note
  *   Unlike [[EuclideanRingCatsConversions]], both directions are supported
  *   here because [[algebra.ring.Field]] provides `euclideanFunction` as a
  *   constant `0` by default, requiring no additional information.
  */
trait FieldCatsConversions:

  /** Derives an [[algebra.ring.Field]] from a [[structures.Field]]. */
  given fieldToCats[X : structures.Field as S]: algebra.ring.Field[X] with

    def plus(x: X, y: X): X  = S.add(x, y)
    def zero: X              = S.zero
    def negate(x: X): X      = S.negate(x)
    def times(x: X, y: X): X = S.multiply(x, y)
    def one: X               = S.one
    def div(x: X, y: X): X   = S.divide(x, y)

  /** Derives a [[structures.Field]] from an [[algebra.ring.Field]]. */
  given fieldFromCats[X : algebra.ring.Field as S]: structures.Field[X] with

    def add(x: X, y: X): X      = S.plus(x, y)
    def zero: X                 = S.zero
    def negate(x: X): X         = S.negate(x)
    def multiply(x: X, y: X): X = S.times(x, y)
    def one: X                  = S.one
    def reciprocate(x: X): X    = S.reciprocal(x)
