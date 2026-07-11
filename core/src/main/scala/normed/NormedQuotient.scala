package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.Quotient

/**
  * A typeclass for algebraic values with the following features:
  *   - Division
  *   - Norm (length)
  */
trait NormedQuotient[X, S] extends Quotient[X], Normed[X, S]

object NormedQuotient:

  type Over[S] = [X] =>> NormedQuotient[X, S]
