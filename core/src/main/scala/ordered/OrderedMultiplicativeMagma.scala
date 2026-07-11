package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeMagma

/**
  * A typeclass for algebraic values with the following features:
  *   - Multiplication
  *   - Total order
  */
trait OrderedMultiplicativeMagma[X] extends MultiplicativeMagma[X], Ordered[X]
