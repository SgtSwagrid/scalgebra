package com.alecdorrington.scalgebra.connector.algebird

import com.alecdorrington.scalgebra as scalgebra
import com.twitter.algebird

/**
  * Implicit conversions between [[scalgebra.arithmetic.AdditiveMonoid]] and
  * [[algebird.Monoid]].
  */
trait AdditiveMonoidAlgebirdConversions:

  /**
    * Derives an [[algebird.Monoid]] from an
    * [[scalgebra.arithmetic.AdditiveMonoid]].
    */
  given additiveMonoidToAlgebird
    : [X : scalgebra.arithmetic.AdditiveMonoid as S] => algebird.Monoid[X]:

    def plus(x: X, y: X): X = x + y
    def zero: X             = S.zero

  /**
    * Derives an [[scalgebra.arithmetic.AdditiveMonoid]] from an
    * [[algebird.Monoid]].
    */
  given additiveMonoidFromAlgebird
    : [X : algebird.Monoid as S] => scalgebra.arithmetic.AdditiveMonoid[X]:

    override def zero: X = S.zero

    extension (x: X) override def add(y: X): X = S.plus(x, y)
