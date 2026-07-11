package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.MultiplicativeMonoid]]
  * and [[spire.algebra.MultiplicativeMonoid]].
  */
trait MultiplicativeMonoidSpireConversions:

  /**
    * Derives a [[spire.algebra.MultiplicativeMonoid]] from a
    * [[scalgebra.arithmetic.MultiplicativeMonoid]].
    */
  given multiplicativeMonoidToSpire
    : [X : scalgebra.arithmetic.MultiplicativeMonoid as S]
      => algebra.MultiplicativeMonoid[X]:

    def times(x: X, y: X): X = x * y
    def one: X               = S.one

  /**
    * Derives a [[scalgebra.arithmetic.MultiplicativeMonoid]] from a
    * [[spire.algebra.MultiplicativeMonoid]].
    */
  given multiplicativeMonoidFromSpire
    : [X : algebra.MultiplicativeMonoid as S]
      => scalgebra.arithmetic.MultiplicativeMonoid[X]:

    override def one: X                        = S.one
    extension (x: X) override def mul(y: X): X = S.times(x, y)
