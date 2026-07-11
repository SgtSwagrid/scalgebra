package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.Ordered

/**
  * A typeclass for algebraic values with the following features:
  *   - Total order
  *   - Rounding to integer values
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Integrality: `x.floor.isIntegral` and `x.ceil.isIntegral`.
  *   - Bounds: `x.floor <= x` and `x <= x.ceil`.
  *   - Optimality: `x.floor` is the greatest integer value not exceeding [[x]],
  *     and `x.ceil` is the least integer value not less than [[x]].
  */
trait Archimedean[X] extends Ordered[X]:

  extension (x: X)

    /**
      * Rounds a value [[x]] downwards (towards negative infinity) to the
      * nearest integer value.
      *
      * @see
      *   [[ceil]].
      */
    def floor: X

    /**
      * Rounds a value [[x]] upwards (towards positive infinity) to the nearest
      * integer value.
      *
      * @see
      *   [[floor]].
      */
    def ceil: X

    /** @return `true` if and only if [[x]] is an integer value. */
    inline def isIntegral: Boolean = equiv(x.floor, x)

    /** @return `true` if and only if [[x]] is not an integer value. */
    inline def isFractional: Boolean = !x.isIntegral
