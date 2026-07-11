package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.Semiring]] and
  * [[algebra.ring.Rig]].
  *
  * @note
  *   [[scalgebra.arithmetic.Semiring]] corresponds to [[algebra.ring.Rig]] (not
  *   [[algebra.ring.Semiring]]), as both provide additive and multiplicative
  *   identities. [[algebra.ring.Semiring]] lacks a multiplicative identity.
  */
trait SemiringCatsConversions:

  /** Derives an [[algebra.ring.Rig]] from a [[scalgebra.arithmetic.Semiring]]. */
  given semiringToCats
    : [X : scalgebra.arithmetic.Semiring as S] => algebra.ring.Rig[X]:

    def plus(x: X, y: X): X  = x + y
    def zero: X              = S.zero
    def times(x: X, y: X): X = x * y
    def one: X               = S.one

  /** Derives a [[scalgebra.arithmetic.Semiring]] from an [[algebra.ring.Rig]]. */
  given semiringFromCats
    : [X : algebra.ring.Rig as S] => scalgebra.arithmetic.Semiring[X]:

    override def zero: X = S.zero
    override def one: X  = S.one

    extension (x: X)

      override def add(y: X): X = S.plus(x, y)
      override def mul(y: X): X = S.times(x, y)
