package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.AdditiveMonoid]] and
  * [[spire.algebra.AdditiveMonoid]].
  */
trait AdditiveMonoidSpireConversions:

  /**
    * Derives a [[spire.algebra.AdditiveMonoid]] from an
    * [[scalgebra.arithmetic.AdditiveMonoid]].
    */
  given additiveMonoidToSpire
    : [X : scalgebra.arithmetic.AdditiveMonoid as S]
      => algebra.AdditiveMonoid[X]:

    def plus(x: X, y: X): X = x + y
    def zero: X             = S.zero

  /**
    * Derives an [[scalgebra.arithmetic.AdditiveMonoid]] from a
    * [[spire.algebra.AdditiveMonoid]].
    */
  given additiveMonoidFromSpire
    : [X : algebra.AdditiveMonoid as S]
      => scalgebra.arithmetic.AdditiveMonoid[X]:

    override def zero: X                       = S.zero
    extension (x: X) override def add(y: X): X = S.plus(x, y)
