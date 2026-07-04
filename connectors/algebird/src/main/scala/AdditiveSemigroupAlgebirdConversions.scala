package com.alecdorrington.scalgebra.connector.algebird

import com.alecdorrington.scalgebra as scalgebra
import com.twitter.algebird

/**
  * Implicit conversions between [[scalgebra.arithmetic.AdditiveSemigroup]] and
  * [[algebird.Semigroup]].
  */
trait AdditiveSemigroupAlgebirdConversions:

  /**
    * Derives an [[algebird.Semigroup]] from an
    * [[scalgebra.arithmetic.AdditiveSemigroup]].
    */
  given additiveSemigroupToAlgebird
    : [X : scalgebra.arithmetic.AdditiveSemigroup as S]
      => algebird.Semigroup[X]:
    def plus(x: X, y: X): X = x + y

  /**
    * Derives an [[scalgebra.arithmetic.AdditiveSemigroup]] from an
    * [[algebird.Semigroup]].
    */
  given additiveSemigroupFromAlgebird
    : [X : algebird.Semigroup as S]
      => scalgebra.arithmetic.AdditiveSemigroup[X]:
    extension (x: X) override def add(y: X): X = S.plus(x, y)
