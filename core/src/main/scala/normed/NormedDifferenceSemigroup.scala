package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.DifferenceSemigroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Subtraction
  *   - Norm (length)
  */
trait NormedDifferenceSemigroup[X, S]
  extends DifferenceSemigroup[X],
          NormedAdditiveSemigroup[X, S],
          NormedDifference[X, S]

object NormedDifferenceSemigroup:

  type Over[S] = [X] =>> NormedDifferenceSemigroup[X, S]
