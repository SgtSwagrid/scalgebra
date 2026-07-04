package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeIdentity

/**
  * A typeclass for algebraic values with the following features:
  *   - Multiplicative identity (`1`)
  *   - Norm (length)
  *
  * @note
  *   Laws, in addition to those inherited, whenever [[S]] carries the
  *   corresponding structure:
  *   - Normalisation: `‖one‖ == 1`.
  */
trait NormedMultiplicativeIdentity[X, S]
  extends MultiplicativeIdentity[X], Normed[X, S]

object NormedMultiplicativeIdentity:

  type Over[S] = [X] =>> NormedMultiplicativeIdentity[X, S]
