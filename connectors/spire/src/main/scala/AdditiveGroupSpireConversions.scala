package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as structures
import spire.algebra

/**
  * Implicit conversions between [[structures.AdditiveGroup]] and
  * [[spire.algebra.AdditiveGroup]].
  */
trait AdditiveGroupSpireConversions:

  /**
    * Derives a [[spire.algebra.AdditiveGroup]] from an
    * [[structures.AdditiveGroup]].
    */
  given additiveGroupToSpire[X : structures.AdditiveGroup as S]
    : algebra.AdditiveGroup[X] with

    def plus(x: X, y: X): X = S.add(x, y)
    def zero: X             = S.zero
    def negate(x: X): X     = S.negate(x)

  /**
    * Derives an [[structures.AdditiveGroup]] from a
    * [[spire.algebra.AdditiveGroup]].
    */
  given additiveGroupFromSpire[X : algebra.AdditiveGroup as S]
    : structures.AdditiveGroup[X] with

    def add(x: X, y: X): X = S.plus(x, y)
    def zero: X            = S.zero
    def negate(x: X): X    = S.negate(x)
