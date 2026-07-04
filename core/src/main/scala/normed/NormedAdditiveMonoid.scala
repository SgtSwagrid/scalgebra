package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.AdditiveMonoid

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Norm (length)
  */
trait NormedAdditiveMonoid[X, S]
  extends AdditiveMonoid[X],
          NormedAdditiveSemigroup[X, S],
          NormedAdditiveIdentity[X, S]

object NormedAdditiveMonoid:

  type Over[S] = [X] =>> NormedAdditiveMonoid[X, S]
