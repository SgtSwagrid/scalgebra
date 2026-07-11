package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.Pseudoring]] and
  * [[algebra.ring.Rng]].
  *
  * @note
  *   [[scalgebra.arithmetic.Pseudoring]] corresponds to [[algebra.ring.Rng]],
  *   both being rings without a multiplicative identity.
  */
trait PseudoringCatsConversions:

  /**
    * Derives an [[algebra.ring.Rng]] from a
    * [[scalgebra.arithmetic.Pseudoring]].
    */
  given pseudoringToCats
    : [X : scalgebra.arithmetic.Pseudoring as S] => algebra.ring.Rng[X]:

    def plus(x: X, y: X): X  = x + y
    def zero: X              = S.zero
    def negate(x: X): X      = x.negate
    def times(x: X, y: X): X = x * y

  /**
    * Derives a [[scalgebra.arithmetic.Pseudoring]] from an
    * [[algebra.ring.Rng]].
    */
  given pseudoringFromCats
    : [X : algebra.ring.Rng as S] => scalgebra.arithmetic.Pseudoring[X]:

    override def zero: X = S.zero

    extension (x: X)

      override def add(y: X): X = S.plus(x, y)
      override def negate: X    = S.negate(x)
      override def mul(y: X): X = S.times(x, y)
