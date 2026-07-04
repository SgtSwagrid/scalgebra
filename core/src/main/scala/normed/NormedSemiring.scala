package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.Semiring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Norm (length)
  */
trait NormedSemiring[X, S]
  extends Semiring[X],
          NormedAdditiveMonoid[X, S],
          NormedMultiplicativeMonoid[X, S]

object NormedSemiring:

  type Over[S] = [X] =>> NormedSemiring[X, S]
