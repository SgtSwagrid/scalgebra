package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra
import spire.algebra

/**
  * Implicit conversions between [[structures.AdditiveMonoid]] and
  * [[spire.algebra.AdditiveMonoid]].
  */
trait AdditiveMonoidSpireConversions:

  /**
    * Derives a [[spire.algebra.AdditiveMonoid]] from an
    * [[structures.AdditiveMonoid]].
    */
  given additiveMonoidToSpire[X : structures.AdditiveMonoid as S]
    : algebra.AdditiveMonoid[X] with

    def plus(x: X, y: X): X = S.add(x, y)
    def zero: X             = S.zero

  /**
    * Derives an [[structures.AdditiveMonoid]] from a
    * [[spire.algebra.AdditiveMonoid]].
    */
  given additiveMonoidFromSpire[X : algebra.AdditiveMonoid as S]
    : structures.AdditiveMonoid[X] with

    def add(x: X, y: X): X = S.plus(x, y)
    def zero: X            = S.zero
