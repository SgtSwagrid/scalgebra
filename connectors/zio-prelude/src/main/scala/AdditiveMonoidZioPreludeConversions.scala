package com.alecdorrington.scalgebra.connector.zioprelude

import com.alecdorrington.{scalgebra as structures}

/**
  * Implicit conversions between [[structures.AdditiveMonoid]] and
  * [[zio.prelude.Identity]].
  */
trait AdditiveMonoidZioPreludeConversions:

  /** Derives a [[zio.prelude.Identity]] from an [[structures.AdditiveMonoid]]. */
  given additiveMonoidToZioPrelude[X : structures.AdditiveMonoid as S]
    : zio.prelude.Identity[X] with

    def combine(x: => X, y: => X): X = S.add(x, y)
    def identity: X                  = S.zero

  /** Derives an [[structures.AdditiveMonoid]] from a [[zio.prelude.Identity]]. */
  given additiveMonoidFromZioPrelude[X : zio.prelude.Identity as S]
    : structures.AdditiveMonoid[X] with

    def add(x: X, y: X): X = S.combine(x, y)
    def zero: X            = S.identity
