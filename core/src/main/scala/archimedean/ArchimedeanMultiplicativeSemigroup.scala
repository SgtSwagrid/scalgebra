package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeSemigroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanMultiplicativeSemigroup[X]
  extends ArchimedeanMultiplicativeMagma[X], OrderedMultiplicativeSemigroup[X]
