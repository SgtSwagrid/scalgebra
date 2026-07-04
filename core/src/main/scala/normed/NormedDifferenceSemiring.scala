package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.DifferenceSemiring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Subtraction
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Norm (length)
  */
trait NormedDifferenceSemiring[X, S]
  extends DifferenceSemiring[X],
          NormedSemiring[X, S],
          NormedDifferenceMonoid[X, S]

object NormedDifferenceSemiring:

  type Over[S] = [X] =>> NormedDifferenceSemiring[X, S]
