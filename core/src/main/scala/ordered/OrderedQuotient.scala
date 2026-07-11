package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.Quotient

/**
  * A typeclass for algebraic values with the following features:
  *   - Division
  *   - Total order
  */
trait OrderedQuotient[X] extends Quotient[X], Ordered[X]
