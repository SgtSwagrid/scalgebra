package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.QuotientSemiring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  *   - Total order
  */
trait OrderedQuotientSemiring[X]
  extends QuotientSemiring[X], OrderedSemiring[X], OrderedQuotientMonoid[X]
