package io.github.sgtswagrid.structures.connector.spire

import io.github.sgtswagrid.structures
import spire.algebra

/**
  * Implicit conversions between [[structures.Field]] and
  * [[spire.algebra.Field]].
  *
  * @note
  *   Unlike [[EuclideanRingSpireConversions]], both directions are supported
  *   here because [[spire.algebra.Field]] provides `euclideanFunction` as a
  *   constant `0` by default, requiring no additional information.
  */
trait FieldSpireConversions:

  /** Derives a [[spire.algebra.Field]] from a [[structures.Field]]. */
  given fieldToSpire[X : structures.Field as S]: algebra.Field[X] with

    def plus(x: X, y: X): X  = S.add(x, y)
    def zero: X              = S.zero
    def negate(x: X): X      = S.negate(x)
    def times(x: X, y: X): X = S.multiply(x, y)
    def one: X               = S.one
    def div(x: X, y: X): X   = S.divide(x, y)

  /** Derives a [[structures.Field]] from a [[spire.algebra.Field]]. */
  given fieldFromSpire[X : algebra.Field as S]: structures.Field[X] with

    def add(x: X, y: X): X      = S.plus(x, y)
    def zero: X                 = S.zero
    def negate(x: X): X         = S.negate(x)
    def multiply(x: X, y: X): X = S.times(x, y)
    def one: X                  = S.one
    def reciprocate(x: X): X    = S.reciprocal(x)
