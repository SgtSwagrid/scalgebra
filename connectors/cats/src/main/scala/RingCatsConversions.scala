package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.Ring]] and
  * [[algebra.ring.Ring]].
  */
trait RingCatsConversions:

  /** Derives an [[algebra.ring.Ring]] from a [[scalgebra.arithmetic.Ring]]. */
  given ringToCats
    : [X : scalgebra.arithmetic.Ring as S] => algebra.ring.Ring[X]:

    def plus(x: X, y: X): X  = x + y
    def zero: X              = S.zero
    def negate(x: X): X      = x.negate
    def times(x: X, y: X): X = x * y
    def one: X               = S.one

  /** Derives a [[scalgebra.arithmetic.Ring]] from an [[algebra.ring.Ring]]. */
  given ringFromCats
    : [X : algebra.ring.Ring as S] => scalgebra.arithmetic.Ring[X]:

    override def zero: X = S.zero
    override def one: X  = S.one

    extension (x: X)

      override def add(y: X): X = S.plus(x, y)
      override def negate: X    = S.negate(x)
      override def mul(y: X): X = S.times(x, y)
