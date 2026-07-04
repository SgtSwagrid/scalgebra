package com.alecdorrington.scalgebra.connector.algebird

import com.alecdorrington.scalgebra as scalgebra
import com.twitter.algebird

/**
  * Implicit conversions between [[scalgebra.arithmetic.Field]] and
  * [[algebird.Field]].
  */
trait FieldAlgebirdConversions:

  /** Derives an [[algebird.Field]] from a [[scalgebra.arithmetic.Field]]. */
  given fieldToAlgebird
    : [X : scalgebra.arithmetic.Field as S] => algebird.Field[X]:

    def plus(x: X, y: X): X  = x + y
    def zero: X              = S.zero
    def negate(x: X): X      = x.negate
    def one: X               = S.one
    def times(x: X, y: X): X = x * y
    def div(x: X, y: X): X   = x / y

  /** Derives a [[scalgebra.arithmetic.Field]] from an [[algebird.Field]]. */
  given fieldFromAlgebird
    : [X : algebird.Field as S] => scalgebra.arithmetic.Field[X]:

    override def zero: X = S.zero
    override def one: X  = S.one

    extension (x: X)

      override def add(y: X): X  = S.plus(x, y)
      override def negate: X     = S.negate(x)
      override def mul(y: X): X  = S.times(x, y)
      override def reciprocal: X = S.reciprocal(x)
