package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as structures

/**
  * Implicit conversions between [[structures.Pseudoring]] and
  * [[algebra.ring.Rng]].
  *
  * @note
  *   [[structures.Pseudoring]] corresponds to [[algebra.ring.Rng]], both being
  *   rings without a multiplicative identity.
  */
trait PseudoringCatsConversions:

  /** Derives an [[algebra.ring.Rng]] from a [[structures.Pseudoring]]. */
  given pseudoringToCats[X : structures.Pseudoring as S]: algebra.ring.Rng[X]
  with

    def plus(x: X, y: X): X  = S.add(x, y)
    def zero: X              = S.zero
    def negate(x: X): X      = S.negate(x)
    def times(x: X, y: X): X = S.multiply(x, y)

  /** Derives a [[structures.Pseudoring]] from an [[algebra.ring.Rng]]. */
  given pseudoringFromCats[X : algebra.ring.Rng as S]: structures.Pseudoring[X]
  with

    def add(x: X, y: X): X      = S.plus(x, y)
    def zero: X                 = S.zero
    def negate(x: X): X         = S.negate(x)
    def multiply(x: X, y: X): X = S.times(x, y)
