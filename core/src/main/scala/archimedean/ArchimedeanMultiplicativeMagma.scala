package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeMagma

/**
  * A typeclass for algebraic values with the following features:
  *   - Multiplication
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanMultiplicativeMagma[X]
  extends Archimedean[X], OrderedMultiplicativeMagma[X]
