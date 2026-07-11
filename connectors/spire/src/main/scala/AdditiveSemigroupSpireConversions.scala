package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.AdditiveSemigroup]] and
  * [[spire.algebra.AdditiveSemigroup]].
  */
trait AdditiveSemigroupSpireConversions:

  /**
    * Derives a [[spire.algebra.AdditiveSemigroup]] from an
    * [[scalgebra.arithmetic.AdditiveSemigroup]].
    */
  given additiveSemigroupToSpire
    : [X : scalgebra.arithmetic.AdditiveSemigroup as S]
      => algebra.AdditiveSemigroup[X]:
    def plus(x: X, y: X): X = x + y

  /**
    * Derives an [[scalgebra.arithmetic.AdditiveSemigroup]] from a
    * [[spire.algebra.AdditiveSemigroup]].
    */
  given additiveSemigroupFromSpire
    : [X : algebra.AdditiveSemigroup as S]
      => scalgebra.arithmetic.AdditiveSemigroup[X]:
    extension (x: X) override def add(y: X): X = S.plus(x, y)
