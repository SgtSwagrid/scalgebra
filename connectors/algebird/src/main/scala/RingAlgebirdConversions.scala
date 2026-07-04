package com.alecdorrington.scalgebra.connector.algebird

import com.alecdorrington.scalgebra as scalgebra
import com.twitter.algebird

/**
  * Implicit conversions between [[scalgebra.arithmetic.Ring]] and
  * [[algebird.Ring]].
  */
trait RingAlgebirdConversions:

  /** Derives an [[algebird.Ring]] from a [[scalgebra.arithmetic.Ring]]. */
  given ringToAlgebird
    : [X : scalgebra.arithmetic.Ring as S] => algebird.Ring[X]:

    def plus(x: X, y: X): X  = x + y
    def zero: X              = S.zero
    def negate(x: X): X      = x.negate
    def one: X               = S.one
    def times(x: X, y: X): X = x * y

  /** Derives a [[scalgebra.arithmetic.Ring]] from an [[algebird.Ring]]. */
  given ringFromAlgebird
    : [X : algebird.Ring as S] => scalgebra.arithmetic.Ring[X]:

    override def zero: X = S.zero
    override def one: X  = S.one

    extension (x: X)

      override def add(y: X): X = S.plus(x, y)
      override def negate: X    = S.negate(x)
      override def mul(y: X): X = S.times(x, y)
