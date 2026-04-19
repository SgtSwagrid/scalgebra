package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as structures

/**
  * Implicit conversions between [[structures.Semiring]] and
  * [[algebra.ring.Rig]].
  *
  * @note
  *   [[structures.Semiring]] corresponds to [[algebra.ring.Rig]] (not
  *   [[algebra.ring.Semiring]]), as both provide additive and multiplicative
  *   identities. [[algebra.ring.Semiring]] lacks a multiplicative identity.
  */
trait SemiringCatsConversions:

  /** Derives an [[algebra.ring.Rig]] from a [[structures.Semiring]]. */
  given semiringToCats[X : structures.Semiring as S]: algebra.ring.Rig[X] with

    def plus(x: X, y: X): X  = S.add(x, y)
    def zero: X              = S.zero
    def times(x: X, y: X): X = S.multiply(x, y)
    def one: X               = S.one

  /** Derives a [[structures.Semiring]] from an [[algebra.ring.Rig]]. */
  given semiringFromCats[X : algebra.ring.Rig as S]: structures.Semiring[X] with

    def add(x: X, y: X): X      = S.plus(x, y)
    def zero: X                 = S.zero
    def multiply(x: X, y: X): X = S.times(x, y)
    def one: X                  = S.one
