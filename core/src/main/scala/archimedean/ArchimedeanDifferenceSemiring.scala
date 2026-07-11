package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemiring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Subtraction
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanDifferenceSemiring[X]
  extends ArchimedeanSemiring[X],
          ArchimedeanDifferenceMonoid[X],
          OrderedDifferenceSemiring[X]:

  extension (x: X)

    /**
      * Rounds a value [[x]] to the nearest integer value (with ties rounded
      * up).
      */
    def round: X = if x.frac :* 2 < one then x.floor else x.ceil
