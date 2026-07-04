package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.AdditiveSemigroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Total order
  */
trait OrderedAdditiveSemigroup[X]
  extends AdditiveSemigroup[X], OrderedAdditiveMagma[X]
