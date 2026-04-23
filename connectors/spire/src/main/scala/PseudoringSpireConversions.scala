package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as structures
import spire.algebra

/**
  * Implicit conversions between [[structures.Pseudoring]] and
  * [[spire.algebra.Rng]].
  *
  * @note
  *   [[structures.Pseudoring]] corresponds to [[spire.algebra.Rng]], both being
  *   rings without a multiplicative identity.
  */
trait PseudoringSpireConversions:

  /** Derives a [[spire.algebra.Rng]] from a [[structures.Pseudoring]]. */
  given pseudoringToSpire[X : structures.Pseudoring as S]: algebra.Rng[X] with

    def plus(x: X, y: X): X  = S.add(x, y)
    def zero: X              = S.zero
    def negate(x: X): X      = S.negate(x)
    def times(x: X, y: X): X = S.multiply(x, y)

  /** Derives a [[structures.Pseudoring]] from a [[spire.algebra.Rng]]. */
  given pseudoringFromSpire[X : algebra.Rng as S]: structures.Pseudoring[X] with

    def add(x: X, y: X): X      = S.plus(x, y)
    def zero: X                 = S.zero
    def negate(x: X): X         = S.negate(x)
    def multiply(x: X, y: X): X = S.times(x, y)
