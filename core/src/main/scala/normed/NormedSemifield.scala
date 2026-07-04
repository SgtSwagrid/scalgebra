package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.Semifield

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  *   - Norm (length)
  */
trait NormedSemifield[X, S]
  extends Semifield[X],
          NormedQuotientSemiring[X, S],
          NormedMultiplicativeGroup[X, S]

object NormedSemifield:

  type Over[S] = [X] =>> NormedSemifield[X, S]
