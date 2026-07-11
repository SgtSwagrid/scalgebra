package com.alecdorrington.scalgebra.connector.zioprelude

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.DifferenceMonoid]] and
  * [[zio.prelude.Inverse]].
  *
  * @note
  *   [[zio.prelude.Inverse.inverse]] is a binary subtraction operation (`l -
  *   r`), not a unary negation, and its laws only require `inverse(a, a) ==
  *   identity`. It therefore corresponds to
  *   [[scalgebra.arithmetic.DifferenceMonoid]] rather than
  *   [[scalgebra.arithmetic.AdditiveGroup]]: types with truncating subtraction
  *   (and no negation) are valid on both sides.
  */
trait DifferenceMonoidZioPreludeConversions:

  /**
    * Derives a [[zio.prelude.Inverse]] from a
    * [[scalgebra.arithmetic.DifferenceMonoid]].
    */
  given differenceMonoidToZioPrelude
    : [X : scalgebra.arithmetic.DifferenceMonoid as S]
      => zio.prelude.Inverse[X]:

    def combine(x: => X, y: => X): X = x + y
    def identity: X                  = S.zero
    def inverse(x: => X, y: => X): X = x - y

  /**
    * Derives a [[scalgebra.arithmetic.DifferenceMonoid]] from a
    * [[zio.prelude.Inverse]].
    */
  given differenceMonoidFromZioPrelude
    : [X : zio.prelude.Inverse as S]
      => scalgebra.arithmetic.DifferenceMonoid[X]:

    override def zero: X = S.identity

    extension (x: X)

      override def add(y: X): X      = S.combine(x, y)
      override def subtract(y: X): X = S.inverse(x, y)
