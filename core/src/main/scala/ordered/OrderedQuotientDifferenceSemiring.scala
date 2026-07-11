package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.QuotientDifferenceSemiring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Subtraction
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  *   - Total order
  */
trait OrderedQuotientDifferenceSemiring[X]
  extends QuotientDifferenceSemiring[X],
          OrderedQuotientSemiring[X],
          OrderedDifferenceSemiring[X]
