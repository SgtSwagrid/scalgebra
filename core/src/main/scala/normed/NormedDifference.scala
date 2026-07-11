package com.alecdorrington.scalgebra
package normed

import com.alecdorrington.scalgebra.arithmetic.Difference

/**
  * A typeclass for algebraic values with the following features:
  *   - Subtraction
  *   - Norm (length)
  */
trait NormedDifference[X, S] extends Difference[X], Normed[X, S]:

  extension (x: X)

    /**
      * Computes the distance between two values [[x]] and [[y]], i.e.
      * `‖x - y‖`.
      */
    def distanceTo(y: X): S = (x - y).length

object NormedDifference:

  type Over[S] = [X] =>> NormedDifference[X, S]
