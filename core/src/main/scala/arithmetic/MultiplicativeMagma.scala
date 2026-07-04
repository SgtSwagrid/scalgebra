package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Multiplication
  */
trait MultiplicativeMagma[X] extends Algebra[X]:

  extension (x: X)

    /** Computes the product of two values [[x]] and [[y]], i.e. `x × y`. */
    def mul(y: X): X

    /** An alias for [[mul]]. */
    inline infix def * (y: X): X = x.mul(y)
