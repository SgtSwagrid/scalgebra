package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.Pseudoring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *   - Norm (length)
  */
trait NormedPseudoring[X, S]
  extends Pseudoring[X],
          NormedAdditiveGroup[X, S],
          NormedMultiplicativeSemigroup[X, S]

object NormedPseudoring:

  type Over[S] = [X] =>> NormedPseudoring[X, S]
