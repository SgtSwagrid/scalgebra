package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.Semifield]] and
  * [[algebra.ring.Semifield]].
  */
trait SemifieldCatsConversions:

  /**
    * Derives an [[algebra.ring.Semifield]] from a
    * [[scalgebra.arithmetic.Semifield]].
    */
  given semifieldToCats
    : [X : scalgebra.arithmetic.Semifield as S] => algebra.ring.Semifield[X]:

    def plus(x: X, y: X): X  = x + y
    def zero: X              = S.zero
    def times(x: X, y: X): X = x * y
    def one: X               = S.one
    def div(x: X, y: X): X   = x / y

  /**
    * Derives a [[scalgebra.arithmetic.Semifield]] from an
    * [[algebra.ring.Semifield]].
    */
  given semifieldFromCats
    : [X : algebra.ring.Semifield as S] => scalgebra.arithmetic.Semifield[X]:

    override def zero: X = S.zero
    override def one: X  = S.one

    extension (x: X)

      override def add(y: X): X  = S.plus(x, y)
      override def mul(y: X): X  = S.times(x, y)
      override def reciprocal: X = S.reciprocal(x)
