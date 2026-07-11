package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.AdditiveMagma

/**
  * A typeclass for algebraic values with the following features:
  *   - Addition
  *   - Total order
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Monotonicity: if `x ≤ y`, then `x + z ≤ y + z` and `z + x ≤ z + y`.
  */
trait OrderedAdditiveMagma[X] extends AdditiveMagma[X], Ordered[X]
