package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.DifferenceSemigroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Subtraction
  *   - Total order
  */
trait OrderedDifferenceSemigroup[X]
  extends DifferenceSemigroup[X], OrderedAdditiveSemigroup[X]
