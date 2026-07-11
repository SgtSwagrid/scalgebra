package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.QuotientSemiring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  *   - Norm (length)
  */
trait NormedQuotientSemiring[X, S]
  extends QuotientSemiring[X], NormedSemiring[X, S], NormedQuotientMonoid[X, S]

object NormedQuotientSemiring:

  type Over[S] = [X] =>> NormedQuotientSemiring[X, S]
