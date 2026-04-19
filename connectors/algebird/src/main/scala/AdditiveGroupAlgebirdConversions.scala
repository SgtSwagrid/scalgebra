package com.alecdorrington.scalgebra.connector.algebird

import com.alecdorrington.{scalgebra as structures}
import com.twitter.algebird

/**
  * Implicit conversions between [[structures.AdditiveGroup]] and
  * [[algebird.Group]].
  */
trait AdditiveGroupAlgebirdConversions:

  /** Derives an [[algebird.Group]] from an [[structures.AdditiveGroup]]. */
  given additiveGroupToAlgebird[X : structures.AdditiveGroup as S]
    : algebird.Group[X] with

    def plus(x: X, y: X): X = S.add(x, y)
    def zero: X             = S.zero
    def negate(x: X): X     = S.negate(x)

  /** Derives an [[structures.AdditiveGroup]] from an [[algebird.Group]]. */
  given additiveGroupFromAlgebird[X : algebird.Group as S]
    : structures.AdditiveGroup[X] with

    def add(x: X, y: X): X = S.plus(x, y)
    def zero: X            = S.zero
    def negate(x: X): X    = S.negate(x)
