package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.AdditiveGroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Norm (length)
  */
trait NormedAdditiveGroup[X, S]
  extends AdditiveGroup[X],
          NormedDifferenceMonoid[X, S],
          NormedAdditiveInverse[X, S]

object NormedAdditiveGroup:

  type Over[S] = [X] =>> NormedAdditiveGroup[X, S]
