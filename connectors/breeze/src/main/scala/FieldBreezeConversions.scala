package io.github.sgtswagrid.structures.connector.breeze

import io.github.sgtswagrid.structures
import breeze.math

/**
  * Implicit conversion from [[math.Field]] to [[structures.Field]].
  *
  * @note
  *   Only the [[math.Field]] → [[structures.Field]] direction is provided. The
  *   reverse requires a norm ([[math.Ring.normImpl]]) and an arbitrary-exponent
  *   power function ([[math.Field.pow]]), which have no counterpart in
  *   [[structures.Field]].
  */
trait FieldBreezeConversions:

  /** Derives a [[structures.Field]] from a [[math.Field]]. */
  given fieldFromBreeze[X : math.Field as S]: structures.Field[X] with
    def add(x: X, y: X): X      = S.+(x, y)
    def zero: X                 = S.zero
    def negate(x: X): X         = S.negate(x)
    def multiply(x: X, y: X): X = S.*(x, y)
    def one: X                  = S.one
    def reciprocate(x: X): X    = S.inverse(x)
