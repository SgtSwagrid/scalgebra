package io.github.sgtswagrid.structures.connector.spire

import io.github.sgtswagrid.structures
import spire.algebra

/**
  * Implicit conversions between [[structures.MultiplicativeSemigroup]] and
  * [[spire.algebra.MultiplicativeSemigroup]].
  */
trait MultiplicativeSemigroupSpireConversions:

  /**
    * Derives a [[spire.algebra.MultiplicativeSemigroup]] from a
    * [[structures.MultiplicativeSemigroup]].
    */
  given multiplicativeSemigroupToSpire[
    X : structures.MultiplicativeSemigroup as S,
  ]: algebra.MultiplicativeSemigroup[X] with
    def times(x: X, y: X): X = S.multiply(x, y)

  /**
    * Derives a [[structures.MultiplicativeSemigroup]] from a
    * [[spire.algebra.MultiplicativeSemigroup]].
    */
  given multiplicativeSemigroupFromSpire[
    X : algebra.MultiplicativeSemigroup as S,
  ]: structures.MultiplicativeSemigroup[X] with
    def multiply(x: X, y: X): X = S.times(x, y)
