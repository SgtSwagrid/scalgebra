package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.AdditiveSemigroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Norm (length)
  */
trait NormedAdditiveSemigroup[X, S]
  extends AdditiveSemigroup[X], NormedAdditiveMagma[X, S]

object NormedAdditiveSemigroup:

  type Over[S] = [X] =>> NormedAdditiveSemigroup[X, S]
