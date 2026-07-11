package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.DifferenceSemifield

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Subtraction
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  *   - Norm (length)
  */
trait NormedDifferenceSemifield[X, S]
  extends DifferenceSemifield[X],
          NormedQuotientDifferenceSemiring[X, S],
          NormedSemifield[X, S]

object NormedDifferenceSemifield:

  type Over[S] = [X] =>> NormedDifferenceSemifield[X, S]
