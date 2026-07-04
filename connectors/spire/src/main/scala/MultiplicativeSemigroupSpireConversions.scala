package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between
  * [[scalgebra.arithmetic.MultiplicativeSemigroup]] and
  * [[spire.algebra.MultiplicativeSemigroup]].
  */
trait MultiplicativeSemigroupSpireConversions:

  /**
    * Derives a [[spire.algebra.MultiplicativeSemigroup]] from a
    * [[scalgebra.arithmetic.MultiplicativeSemigroup]].
    */
  given multiplicativeSemigroupToSpire
    : [X : scalgebra.arithmetic.MultiplicativeSemigroup as S]
      => algebra.MultiplicativeSemigroup[X]:
    def times(x: X, y: X): X = x * y

  /**
    * Derives a [[scalgebra.arithmetic.MultiplicativeSemigroup]] from a
    * [[spire.algebra.MultiplicativeSemigroup]].
    */
  given multiplicativeSemigroupFromSpire
    : [X : algebra.MultiplicativeSemigroup as S]
      => scalgebra.arithmetic.MultiplicativeSemigroup[X]:
    extension (x: X) override def mul(y: X): X = S.times(x, y)
