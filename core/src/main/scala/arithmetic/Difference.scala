package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Subtraction
  */
trait Difference[X] extends Algebra[X]:

  extension (x: X)

    /**
      * Computes the difference between two values [[x]] and [[y]], i.e.
      * `x - y`.
      */
    def subtract(y: X): X

    /** An alias for [[subtract]]. */
    inline infix def - (y: X): X = x.subtract(y)
