package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedAdditiveIdentity

/**
  * A typeclass for algebraic values with the following features:
  *   - Additive identity (`0`)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanAdditiveIdentity[X]
  extends Archimedean[X], OrderedAdditiveIdentity[X]:

  extension (x: X)

    /**
      * Rounds a value [[x]] towards [[zero]] (downwards if [[x]] is positive or
      * upwards if [[x]] is negative).
      */
    def truncate: X = if x.isPositive then x.floor else x.ceil
