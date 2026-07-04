package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeGroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  *   - Norm (length)
  */
trait NormedMultiplicativeGroup[X, S]
  extends MultiplicativeGroup[X],
          NormedQuotientMonoid[X, S],
          NormedMultiplicativeInverse[X, S]

object NormedMultiplicativeGroup:

  type Over[S] = [X] =>> NormedMultiplicativeGroup[X, S]
