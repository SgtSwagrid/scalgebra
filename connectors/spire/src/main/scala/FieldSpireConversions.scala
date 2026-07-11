package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.Field]] and
  * [[spire.algebra.Field]].
  *
  * @note
  *   Unlike [[QuotientRingSpireConversions]], both directions are supported
  *   here because [[spire.algebra.Field]] provides `euclideanFunction` as a
  *   constant `0` by default, requiring no additional information.
  */
trait FieldSpireConversions:

  /** Derives a [[spire.algebra.Field]] from a [[scalgebra.arithmetic.Field]]. */
  given fieldToSpire: [X : scalgebra.arithmetic.Field as S] => algebra.Field[X]:

    def plus(x: X, y: X): X  = x + y
    def zero: X              = S.zero
    def negate(x: X): X      = x.negate
    def times(x: X, y: X): X = x * y
    def one: X               = S.one
    def div(x: X, y: X): X   = x / y

  /** Derives a [[scalgebra.arithmetic.Field]] from a [[spire.algebra.Field]]. */
  given fieldFromSpire
    : [X : algebra.Field as S] => scalgebra.arithmetic.Field[X]:

    override def zero: X = S.zero
    override def one: X  = S.one

    extension (x: X)

      override def add(y: X): X  = S.plus(x, y)
      override def negate: X     = S.negate(x)
      override def mul(y: X): X  = S.times(x, y)
      override def reciprocal: X = S.reciprocal(x)
