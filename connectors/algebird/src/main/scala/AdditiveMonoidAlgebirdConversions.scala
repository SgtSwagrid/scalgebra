package com.alecdorrington.scalgebra.connector.algebird

import com.alecdorrington.scalgebra as structures
import com.twitter.algebird

/**
  * Implicit conversions between [[structures.AdditiveMonoid]] and
  * [[algebird.Monoid]].
  */
trait AdditiveMonoidAlgebirdConversions:

  /** Derives an [[algebird.Monoid]] from an [[structures.AdditiveMonoid]]. */
  given additiveMonoidToAlgebird[X : structures.AdditiveMonoid as S]
    : algebird.Monoid[X] with

    def plus(x: X, y: X): X = S.add(x, y)
    def zero: X             = S.zero

  /** Derives an [[structures.AdditiveMonoid]] from an [[algebird.Monoid]]. */
  given additiveMonoidFromAlgebird[X : algebird.Monoid as S]
    : structures.AdditiveMonoid[X] with

    def add(x: X, y: X): X = S.plus(x, y)
    def zero: X            = S.zero
