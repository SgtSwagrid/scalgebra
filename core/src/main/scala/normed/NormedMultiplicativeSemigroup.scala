package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeSemigroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Norm (length)
  */
trait NormedMultiplicativeSemigroup[X, S]
  extends MultiplicativeSemigroup[X], NormedMultiplicativeMagma[X, S]

object NormedMultiplicativeSemigroup:

  type Over[S] = [X] =>> NormedMultiplicativeSemigroup[X, S]
