package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.Ring]] and
  * [[spire.algebra.Ring]].
  */
trait RingSpireConversions:

  /** Derives a [[spire.algebra.Ring]] from a [[scalgebra.arithmetic.Ring]]. */
  given ringToSpire: [X : scalgebra.arithmetic.Ring as S] => algebra.Ring[X]:

    def plus(x: X, y: X): X  = x + y
    def zero: X              = S.zero
    def negate(x: X): X      = x.negate
    def times(x: X, y: X): X = x * y
    def one: X               = S.one

  /** Derives a [[scalgebra.arithmetic.Ring]] from a [[spire.algebra.Ring]]. */
  given ringFromSpire: [X : algebra.Ring as S] => scalgebra.arithmetic.Ring[X]:

    override def zero: X = S.zero
    override def one: X  = S.one

    extension (x: X)

      override def add(y: X): X = S.plus(x, y)
      override def negate: X    = S.negate(x)
      override def mul(y: X): X = S.times(x, y)
