package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.AdditiveMagma

/**
  * A typeclass for algebraic values with the following features:
  *   - Addition
  *   - Norm (length)
  *
  * @note
  *   Laws, in addition to those inherited, whenever [[S]] carries the
  *   corresponding structure:
  *   - Subadditivity: `‖x + y‖ ≤ ‖x‖ + ‖y‖`.
  */
trait NormedAdditiveMagma[X, S] extends AdditiveMagma[X], Normed[X, S]

object NormedAdditiveMagma:

  type Over[S] = [X] =>> NormedAdditiveMagma[X, S]
