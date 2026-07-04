package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.Field

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  *   - Norm (length)
  */
trait NormedField[X, S]
  extends Field[X], NormedQuotientRing[X, S], NormedDifferenceSemifield[X, S]

object NormedField:

  type Over[S] = [X] =>> NormedField[X, S]
