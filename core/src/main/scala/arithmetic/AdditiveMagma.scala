package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Addition
  */
trait AdditiveMagma[X] extends Algebra[X]:

  extension (x: X)

    /** Computes the sum of two values [[x]] and [[y]], i.e. `x + y`. */
    def add(y: X): X

    /** An alias for [[add]]. */
    inline infix def + (y: X): X = x.add(y)
