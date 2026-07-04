package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.QuotientRing

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  *   - Norm (length)
  */
trait NormedQuotientRing[X, S]
  extends QuotientRing[X],
          NormedRing[X, S],
          NormedQuotientDifferenceSemiring[X, S]

object NormedQuotientRing:

  type Over[S] = [X] =>> NormedQuotientRing[X, S]
