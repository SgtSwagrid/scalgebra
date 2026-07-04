package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.Semiring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Total order
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Monotonicity: if `x <= y` and `zero <= z`, then `x × z <= y × z` and
  *     `z × x <= z × y`.
  */
trait OrderedSemiring[X]
  extends Semiring[X], OrderedAdditiveMonoid[X], OrderedMultiplicativeMonoid[X]
