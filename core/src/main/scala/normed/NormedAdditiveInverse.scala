package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.AdditiveInverse

/**
  * A typeclass for algebraic values with the following features:
  *   - Additive inverse (negation)
  *   - Norm (length)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Symmetry: `‖-x‖ == ‖x‖`.
  */
trait NormedAdditiveInverse[X, S] extends AdditiveInverse[X], Normed[X, S]

object NormedAdditiveInverse:

  type Over[S] = [X] =>> NormedAdditiveInverse[X, S]
