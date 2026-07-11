package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.Pseudoring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *   - Total order
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Monotonicity: if `x ≤ y` and `zero ≤ z`, then `x × z ≤ y × z` and
  *     `z × x ≤ z × y`.
  */
trait OrderedPseudoring[X]
  extends Pseudoring[X],
          OrderedAdditiveGroup[X],
          OrderedMultiplicativeSemigroup[X]
