package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between
  * [[scalgebra.arithmetic.MultiplicativeSemigroup]] and
  * [[algebra.ring.MultiplicativeSemigroup]].
  */
trait MultiplicativeSemigroupCatsConversions:

  /**
    * Derives an [[algebra.ring.MultiplicativeSemigroup]] from a
    * [[scalgebra.arithmetic.MultiplicativeSemigroup]].
    */
  given multiplicativeSemigroupToCats
    : [X : scalgebra.arithmetic.MultiplicativeSemigroup as S]
      => algebra.ring.MultiplicativeSemigroup[X]:
    def times(x: X, y: X): X = x * y

  /**
    * Derives a [[scalgebra.arithmetic.MultiplicativeSemigroup]] from an
    * [[algebra.ring.MultiplicativeSemigroup]].
    */
  given multiplicativeSemigroupFromCats
    : [X : algebra.ring.MultiplicativeSemigroup as S]
      => scalgebra.arithmetic.MultiplicativeSemigroup[X]:
    extension (x: X) override def mul(y: X): X = S.times(x, y)
