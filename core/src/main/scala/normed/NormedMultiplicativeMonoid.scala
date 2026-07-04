package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeMonoid

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Norm (length)
  */
trait NormedMultiplicativeMonoid[X, S]
  extends MultiplicativeMonoid[X],
          NormedMultiplicativeSemigroup[X, S],
          NormedMultiplicativeIdentity[X, S]

object NormedMultiplicativeMonoid:

  type Over[S] = [X] =>> NormedMultiplicativeMonoid[X, S]
