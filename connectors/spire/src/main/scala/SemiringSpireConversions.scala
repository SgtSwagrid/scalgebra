package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.Semiring]] and
  * [[spire.algebra.Rig]].
  *
  * @note
  *   [[scalgebra.arithmetic.Semiring]] corresponds to [[spire.algebra.Rig]]
  *   (not [[spire.algebra.Semiring]]), as both provide additive and
  *   multiplicative identities. [[spire.algebra.Semiring]] lacks a
  *   multiplicative identity.
  */
trait SemiringSpireConversions:

  /** Derives a [[spire.algebra.Rig]] from a [[scalgebra.arithmetic.Semiring]]. */
  given semiringToSpire
    : [X : scalgebra.arithmetic.Semiring as S] => algebra.Rig[X]:

    def plus(x: X, y: X): X  = x + y
    def zero: X              = S.zero
    def times(x: X, y: X): X = x * y
    def one: X               = S.one

  /** Derives a [[scalgebra.arithmetic.Semiring]] from a [[spire.algebra.Rig]]. */
  given semiringFromSpire
    : [X : algebra.Rig as S] => scalgebra.arithmetic.Semiring[X]:

    override def zero: X = S.zero
    override def one: X  = S.one

    extension (x: X)

      override def add(y: X): X = S.plus(x, y)
      override def mul(y: X): X = S.times(x, y)
