package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeInverse

/**
  * A typeclass for algebraic values with the following features:
  *   - Multiplicative inverse (reciprocation)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanMultiplicativeInverse[X]
  extends Archimedean[X], OrderedMultiplicativeInverse[X]
