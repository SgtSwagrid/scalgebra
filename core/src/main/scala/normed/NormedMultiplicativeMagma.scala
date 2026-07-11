package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeMagma

/**
  * A typeclass for algebraic values with the following features:
  *   - Multiplication
  *   - Norm (length)
  *
  * @note
  *   Laws, in addition to those inherited, whenever [[S]] carries the
  *   corresponding structure:
  *   - Submultiplicativity: `‖x × y‖ ≤ ‖x‖ × ‖y‖`.
  */
trait NormedMultiplicativeMagma[X, S]
  extends MultiplicativeMagma[X], Normed[X, S]

object NormedMultiplicativeMagma:

  type Over[S] = [X] =>> NormedMultiplicativeMagma[X, S]
