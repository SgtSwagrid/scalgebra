package com.alecdorrington.scalgebra.connector.scalaz

import com.alecdorrington.{scalgebra as structures}

/**
  * Implicit conversions between [[structures.AdditiveMonoid]] and
  * [[scalaz.Monoid]].
  */
trait AdditiveMonoidScalazConversions:

  /** Derives a [[scalaz.Monoid]] from an [[structures.AdditiveMonoid]]. */
  given additiveMonoidToScalaz[X : structures.AdditiveMonoid as S]
    : scalaz.Monoid[X] with

    def append(x: X, y: => X): X = S.add(x, y)
    def zero: X                  = S.zero

  /** Derives an [[structures.AdditiveMonoid]] from a [[scalaz.Monoid]]. */
  given additiveMonoidFromScalaz[X : scalaz.Monoid as S]
    : structures.AdditiveMonoid[X] with

    def add(x: X, y: X): X = S.append(x, y)
    def zero: X            = S.zero
