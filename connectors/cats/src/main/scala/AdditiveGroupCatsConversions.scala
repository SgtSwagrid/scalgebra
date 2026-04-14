package io.github.sgtswagrid.structures.connector.cats

import io.github.sgtswagrid.structures

/**
  * Implicit conversions between [[structures.AdditiveGroup]] and
  * [[algebra.ring.AdditiveGroup]].
  */
trait AdditiveGroupCatsConversions:

  /**
    * Derives an [[algebra.ring.AdditiveGroup]] from an
    * [[structures.AdditiveGroup]].
    */
  given additiveGroupToCats[X : structures.AdditiveGroup as S]
    : algebra.ring.AdditiveGroup[X] with

    def plus(x: X, y: X): X = S.add(x, y)
    def zero: X             = S.zero
    def negate(x: X): X     = S.negate(x)

  /**
    * Derives an [[structures.AdditiveGroup]] from an
    * [[algebra.ring.AdditiveGroup]].
    */
  given additiveGroupFromCats[X : algebra.ring.AdditiveGroup as S]
    : structures.AdditiveGroup[X] with

    def add(x: X, y: X): X = S.plus(x, y)
    def zero: X            = S.zero
    def negate(x: X): X    = S.negate(x)
