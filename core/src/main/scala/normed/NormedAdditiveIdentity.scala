package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.AdditiveIdentity

/**
  * A typeclass for algebraic values with the following features:
  *   - Additive identity (`0`)
  *   - Norm (length)
  *
  * @note
  *   Laws, in addition to those inherited, whenever [[S]] carries the
  *   corresponding structure:
  *   - Definiteness: `‖x‖ == 0` if and only if `x == zero`.
  */
trait NormedAdditiveIdentity[X, S] extends AdditiveIdentity[X], Normed[X, S]

object NormedAdditiveIdentity:

  type Over[S] = [X] =>> NormedAdditiveIdentity[X, S]
