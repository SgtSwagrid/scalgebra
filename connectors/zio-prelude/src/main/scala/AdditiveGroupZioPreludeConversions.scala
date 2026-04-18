package com.alecdorrington.scalgebra.connector.zioprelude

import com.alecdorrington.scalgebra

/**
  * Implicit conversions between [[structures.AdditiveGroup]] and
  * [[zio.prelude.Inverse]].
  *
  * @note
  *   [[zio.prelude.Inverse.inverse]] is a binary subtraction operation
  *   (`l - r`), not a unary negation. The conversion to
  *   [[structures.AdditiveGroup]] derives `negate(x)` as
  *   `inverse(identity, x)`, i.e. `0 - x`.
  */
trait AdditiveGroupZioPreludeConversions:

  /** Derives a [[zio.prelude.Inverse]] from an [[structures.AdditiveGroup]]. */
  given additiveGroupToZioPrelude[X : structures.AdditiveGroup as S]
    : zio.prelude.Inverse[X] with

    def combine(x: => X, y: => X): X  = S.add(x, y)
    def identity: X                   = S.zero
    def inverse(x: => X, y: => X): X  = S.subtract(x, y)

  /** Derives an [[structures.AdditiveGroup]] from a [[zio.prelude.Inverse]]. */
  given additiveGroupFromZioPrelude[X : zio.prelude.Inverse as S]
    : structures.AdditiveGroup[X] with

    def add(x: X, y: X): X  = S.combine(x, y)
    def zero: X             = S.identity
    def negate(x: X): X     = S.inverse(S.identity, x)
