package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedAdditiveSemigroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanAdditiveSemigroup[X]
  extends ArchimedeanAdditiveMagma[X], OrderedAdditiveSemigroup[X]
