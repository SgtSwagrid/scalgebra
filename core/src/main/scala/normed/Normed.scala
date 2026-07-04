package com.alecdorrington.scalgebra
package normed

/**
  * A typeclass for algebraic values with the following features:
  *   - Norm (length)
  */
trait Normed[X, S] extends Algebra[X]:

  extension (x: X)

    /** Computes the norm of a value [[x]], i.e. `‖x‖`. */
    def length: S

object Normed:

  type Over[S] = [X] =>> Normed[X, S]
