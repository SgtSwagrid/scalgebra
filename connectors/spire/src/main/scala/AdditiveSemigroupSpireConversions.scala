package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra
import spire.algebra

/**
  * Implicit conversions between [[structures.AdditiveSemigroup]] and
  * [[spire.algebra.AdditiveSemigroup]].
  */
trait AdditiveSemigroupSpireConversions:

  /**
    * Derives a [[spire.algebra.AdditiveSemigroup]] from an
    * [[structures.AdditiveSemigroup]].
    */
  given additiveSemigroupToSpire[X : structures.AdditiveSemigroup as S]
    : algebra.AdditiveSemigroup[X] with
    def plus(x: X, y: X): X = S.add(x, y)

  /**
    * Derives an [[structures.AdditiveSemigroup]] from a
    * [[spire.algebra.AdditiveSemigroup]].
    */
  given additiveSemigroupFromSpire[X : algebra.AdditiveSemigroup as S]
    : structures.AdditiveSemigroup[X] with
    def add(x: X, y: X): X = S.plus(x, y)
