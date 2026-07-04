package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.QuotientSemigroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Division
  *   - Norm (length)
  */
trait NormedQuotientSemigroup[X, S]
  extends QuotientSemigroup[X],
          NormedMultiplicativeSemigroup[X, S],
          NormedQuotient[X, S]

object NormedQuotientSemigroup:

  type Over[S] = [X] =>> NormedQuotientSemigroup[X, S]
