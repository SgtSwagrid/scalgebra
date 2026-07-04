package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.QuotientDifferenceSemiring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Subtraction
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  *   - Norm (length)
  */
trait NormedQuotientDifferenceSemiring[X, S]
  extends QuotientDifferenceSemiring[X],
          NormedQuotientSemiring[X, S],
          NormedDifferenceSemiring[X, S]

object NormedQuotientDifferenceSemiring:

  type Over[S] = [X] =>> NormedQuotientDifferenceSemiring[X, S]
