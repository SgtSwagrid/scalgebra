package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.Ring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Total order
  */
trait OrderedRing[X]
  extends Ring[X], OrderedPseudoring[X], OrderedDifferenceSemiring[X]:

  extension (x: X)

    /**
      * Determines the sign of a value [[x]], given by [[one]] if [[x]] is
      * positive, the negation of [[one]] if [[x]] is negative, or [[zero]] if
      * [[x]] is itself [[zero]].
      */
    def sign: X =
      if x < zero then one.negate else if x > zero then one else zero
