package io.github.sgtswagrid.structures.connector.algebird

import com.twitter.algebird
import io.github.sgtswagrid.structures

/**
  * Implicit conversions between [[structures.AdditiveSemigroup]] and
  * [[algebird.Semigroup]].
  */
trait AdditiveSemigroupAlgebirdConversions:

  /**
    * Derives an [[algebird.Semigroup]] from an
    * [[structures.AdditiveSemigroup]].
    */
  given additiveSemigroupToAlgebird[X : structures.AdditiveSemigroup as S]
    : algebird.Semigroup[X] with
    def plus(x: X, y: X): X = S.add(x, y)

  /**
    * Derives an [[structures.AdditiveSemigroup]] from an
    * [[algebird.Semigroup]].
    */
  given additiveSemigroupFromAlgebird[X : algebird.Semigroup as S]
    : structures.AdditiveSemigroup[X] with
    def add(x: X, y: X): X = S.plus(x, y)
