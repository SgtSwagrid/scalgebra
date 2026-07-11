package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.AdditiveGroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Total order
  */
trait OrderedAdditiveGroup[X]
  extends AdditiveGroup[X],
          OrderedDifferenceMonoid[X],
          OrderedAdditiveInverse[X]:

  extension (x: X)

    /**
      * Computes the [absolute
      * value](https://en.wikipedia.org/wiki/Absolute_value) of a value [[x]],
      * i.e. `|x| = x if x ≥ 0 or else -x if x < 0`.
      */
    def abs: X = if x < zero then x.negate else x
