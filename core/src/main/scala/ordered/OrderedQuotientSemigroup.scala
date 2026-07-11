package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.QuotientSemigroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Division
  *   - Total order
  */
trait OrderedQuotientSemigroup[X]
  extends QuotientSemigroup[X], OrderedMultiplicativeSemigroup[X]
