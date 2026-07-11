package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.Difference

/**
  * A typeclass for algebraic values with the following features:
  *   - Subtraction
  *   - Total order
  */
trait OrderedDifference[X] extends Difference[X], Ordered[X]
