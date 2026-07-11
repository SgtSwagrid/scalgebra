package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.DifferenceSemiring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Subtraction
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Total order
  */
trait OrderedDifferenceSemiring[X]
  extends DifferenceSemiring[X], OrderedSemiring[X], OrderedDifferenceMonoid[X]
