package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.MultiplicativeMonoid]]
  * and [[algebra.ring.MultiplicativeMonoid]].
  */
trait MultiplicativeMonoidCatsConversions:

  /**
    * Derives an [[algebra.ring.MultiplicativeMonoid]] from a
    * [[scalgebra.arithmetic.MultiplicativeMonoid]].
    */
  given multiplicativeMonoidToCats
    : [X : scalgebra.arithmetic.MultiplicativeMonoid as S]
      => algebra.ring.MultiplicativeMonoid[X]:

    def times(x: X, y: X): X = x * y
    def one: X               = S.one

  /**
    * Derives a [[scalgebra.arithmetic.MultiplicativeMonoid]] from an
    * [[algebra.ring.MultiplicativeMonoid]].
    */
  given multiplicativeMonoidFromCats
    : [X : algebra.ring.MultiplicativeMonoid as S]
      => scalgebra.arithmetic.MultiplicativeMonoid[X]:

    override def one: X                        = S.one
    extension (x: X) override def mul(y: X): X = S.times(x, y)
