package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeSemigroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Total order
  */
trait OrderedMultiplicativeSemigroup[X]
  extends MultiplicativeSemigroup[X], OrderedMultiplicativeMagma[X]
