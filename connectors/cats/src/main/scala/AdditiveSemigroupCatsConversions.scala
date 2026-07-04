package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.AdditiveSemigroup]] and
  * [[algebra.ring.AdditiveSemigroup]].
  */
trait AdditiveSemigroupCatsConversions:

  /**
    * Derives an [[algebra.ring.AdditiveSemigroup]] from an
    * [[scalgebra.arithmetic.AdditiveSemigroup]].
    */
  given additiveSemigroupToCats
    : [X : scalgebra.arithmetic.AdditiveSemigroup as S]
      => algebra.ring.AdditiveSemigroup[X]:
    def plus(x: X, y: X): X = x + y

  /**
    * Derives an [[scalgebra.arithmetic.AdditiveSemigroup]] from an
    * [[algebra.ring.AdditiveSemigroup]].
    */
  given additiveSemigroupFromCats
    : [X : algebra.ring.AdditiveSemigroup as S]
      => scalgebra.arithmetic.AdditiveSemigroup[X]:
    extension (x: X) override def add(y: X): X = S.plus(x, y)
