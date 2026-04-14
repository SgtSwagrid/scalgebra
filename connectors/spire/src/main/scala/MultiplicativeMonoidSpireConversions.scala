package io.github.sgtswagrid.structures.connector.spire

import io.github.sgtswagrid.structures
import spire.algebra

/**
  * Implicit conversions between [[structures.MultiplicativeMonoid]] and
  * [[spire.algebra.MultiplicativeMonoid]].
  */
trait MultiplicativeMonoidSpireConversions:

  /**
    * Derives a [[spire.algebra.MultiplicativeMonoid]] from a
    * [[structures.MultiplicativeMonoid]].
    */
  given multiplicativeMonoidToSpire[X : structures.MultiplicativeMonoid as S]
    : algebra.MultiplicativeMonoid[X] with

    def times(x: X, y: X): X = S.multiply(x, y)
    def one: X               = S.one

  /**
    * Derives a [[structures.MultiplicativeMonoid]] from a
    * [[spire.algebra.MultiplicativeMonoid]].
    */
  given multiplicativeMonoidFromSpire[X : algebra.MultiplicativeMonoid as S]
    : structures.MultiplicativeMonoid[X] with

    def multiply(x: X, y: X): X = S.times(x, y)
    def one: X                  = S.one
