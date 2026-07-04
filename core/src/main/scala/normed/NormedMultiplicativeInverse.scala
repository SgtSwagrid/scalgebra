package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeInverse

/**
  * A typeclass for algebraic values with the following features:
  *   - Multiplicative inverse (reciprocation)
  *   - Norm (length)
  */
trait NormedMultiplicativeInverse[X, S]
  extends MultiplicativeInverse[X], Normed[X, S]

object NormedMultiplicativeInverse:

  type Over[S] = [X] =>> NormedMultiplicativeInverse[X, S]
