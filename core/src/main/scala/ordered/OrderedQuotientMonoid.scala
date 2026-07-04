package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.QuotientMonoid

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  *   - Total order
  */
trait OrderedQuotientMonoid[X]
  extends QuotientMonoid[X],
          OrderedQuotientSemigroup[X],
          OrderedMultiplicativeMonoid[X]
