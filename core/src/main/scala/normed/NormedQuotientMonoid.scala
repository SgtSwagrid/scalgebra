package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.QuotientMonoid

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  *   - Norm (length)
  */
trait NormedQuotientMonoid[X, S]
  extends QuotientMonoid[X],
          NormedQuotientSemigroup[X, S],
          NormedMultiplicativeMonoid[X, S]

object NormedQuotientMonoid:

  type Over[S] = [X] =>> NormedQuotientMonoid[X, S]
