package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.AdditiveInverse

/**
  * A typeclass for algebraic values with the following features:
  *   - Additive inverse (negation)
  *   - Total order
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Antitonicity: if `x ≤ y`, then `-y ≤ -x`.
  */
trait OrderedAdditiveInverse[X] extends AdditiveInverse[X], Ordered[X]
