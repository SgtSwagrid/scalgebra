package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.AdditiveIdentity

/**
  * A typeclass for algebraic values with the following features:
  *   - Additive identity (`0`)
  *   - Total order
  */
trait OrderedAdditiveIdentity[X] extends AdditiveIdentity[X], Ordered[X]:

  extension (x: X)

    /**
      * @return
      *   `true` if and only if [[x]] is strictly positive, i.e. `x > 0`.
      */
    inline def isPositive: Boolean = x > zero

    /**
      * @return
      *   `true` if and only if [[x]] is strictly negative, i.e. `x < 0`.
      */
    inline def isNegative: Boolean = x < zero

    /**
      * @return
      *   `true` if and only if [[x]] is positive or [[zero]], i.e. `x ≥ 0`.
      */
    inline def isNonNegative: Boolean = x >= zero

    /**
      * @return
      *   `true` if and only if [[x]] is negative or [[zero]], i.e. `x ≤ 0`.
      */
    inline def isNonPositive: Boolean = x <= zero
