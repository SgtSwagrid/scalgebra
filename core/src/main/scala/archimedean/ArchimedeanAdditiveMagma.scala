package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedAdditiveMagma

/**
  * A typeclass for algebraic values with the following features:
  *   - Addition
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanAdditiveMagma[X]
  extends Archimedean[X], OrderedAdditiveMagma[X]
