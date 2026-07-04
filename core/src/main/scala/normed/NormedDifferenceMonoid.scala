package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.DifferenceMonoid

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Subtraction
  *   - Norm (length)
  */
trait NormedDifferenceMonoid[X, S]
  extends DifferenceMonoid[X],
          NormedDifferenceSemigroup[X, S],
          NormedAdditiveMonoid[X, S]

object NormedDifferenceMonoid:

  type Over[S] = [X] =>> NormedDifferenceMonoid[X, S]
