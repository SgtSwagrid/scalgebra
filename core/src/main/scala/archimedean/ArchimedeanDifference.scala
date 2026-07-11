package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedDifference

/**
  * A typeclass for algebraic values with the following features:
  *   - Subtraction
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanDifference[X] extends Archimedean[X], OrderedDifference[X]:

  extension (x: X)

    /**
      * Computes the fractional part of [[x]], i.e. `x - ⌊x⌋`.
      *
      * @note
      *   The result will always fall in the half-open interval `[0, 1)`.
      */
    def frac: X = x - x.floor
