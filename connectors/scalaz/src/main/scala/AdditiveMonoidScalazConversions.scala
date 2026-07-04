package com.alecdorrington.scalgebra.connector.scalaz

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.AdditiveMonoid]] and
  * [[scalaz.Monoid]].
  */
trait AdditiveMonoidScalazConversions:

  /**
    * Derives a [[scalaz.Monoid]] from an
    * [[scalgebra.arithmetic.AdditiveMonoid]].
    */
  given additiveMonoidToScalaz
    : [X : scalgebra.arithmetic.AdditiveMonoid as S] => scalaz.Monoid[X]:

    def append(x: X, y: => X): X = x + y
    def zero: X                  = S.zero

  /**
    * Derives an [[scalgebra.arithmetic.AdditiveMonoid]] from a
    * [[scalaz.Monoid]].
    */
  given additiveMonoidFromScalaz
    : [X : scalaz.Monoid as S] => scalgebra.arithmetic.AdditiveMonoid[X]:

    override def zero: X = S.zero

    extension (x: X) override def add(y: X): X = S.append(x, y)
