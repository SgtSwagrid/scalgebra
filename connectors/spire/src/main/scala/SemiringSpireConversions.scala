package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra
import spire.algebra

/**
  * Implicit conversions between [[structures.Semiring]] and
  * [[spire.algebra.Rig]].
  *
  * @note
  *   [[structures.Semiring]] corresponds to [[spire.algebra.Rig]] (not
  *   [[spire.algebra.Semiring]]), as both provide additive and multiplicative
  *   identities. [[spire.algebra.Semiring]] lacks these identities.
  */
trait SemiringSpireConversions:

  /** Derives a [[spire.algebra.Rig]] from a [[structures.Semiring]]. */
  given semiringToSpire[X : structures.Semiring as S]: algebra.Rig[X] with

    def plus(x: X, y: X): X  = S.add(x, y)
    def zero: X              = S.zero
    def times(x: X, y: X): X = S.multiply(x, y)
    def one: X               = S.one

  /** Derives a [[structures.Semiring]] from a [[spire.algebra.Rig]]. */
  given semiringFromSpire[X : algebra.Rig as S]: structures.Semiring[X] with

    def add(x: X, y: X): X      = S.plus(x, y)
    def zero: X                 = S.zero
    def multiply(x: X, y: X): X = S.times(x, y)
    def one: X                  = S.one
