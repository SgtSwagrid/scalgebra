package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.Pseudoring]] and
  * [[spire.algebra.Rng]].
  *
  * @note
  *   [[scalgebra.arithmetic.Pseudoring]] corresponds to [[spire.algebra.Rng]],
  *   both being rings without a multiplicative identity.
  */
trait PseudoringSpireConversions:

  /**
    * Derives a [[spire.algebra.Rng]] from a
    * [[scalgebra.arithmetic.Pseudoring]].
    */
  given pseudoringToSpire
    : [X : scalgebra.arithmetic.Pseudoring as S] => algebra.Rng[X]:

    def plus(x: X, y: X): X  = x + y
    def zero: X              = S.zero
    def negate(x: X): X      = x.negate
    def times(x: X, y: X): X = x * y

  /**
    * Derives a [[scalgebra.arithmetic.Pseudoring]] from a
    * [[spire.algebra.Rng]].
    */
  given pseudoringFromSpire
    : [X : algebra.Rng as S] => scalgebra.arithmetic.Pseudoring[X]:

    override def zero: X = S.zero

    extension (x: X)

      override def add(y: X): X = S.plus(x, y)
      override def negate: X    = S.negate(x)
      override def mul(y: X): X = S.times(x, y)
