package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.Ring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Norm (length)
  */
trait NormedRing[X, S]
  extends Ring[X], NormedPseudoring[X, S], NormedDifferenceSemiring[X, S]

object NormedRing:

  type Over[S] = [X] =>> NormedRing[X, S]
