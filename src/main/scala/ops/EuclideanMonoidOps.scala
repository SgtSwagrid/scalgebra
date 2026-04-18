package com.alecdorrington.scalgebra
package ops

import com.alecdorrington.scalgebra.EuclideanMonoid

/** Extension methods for [[EuclideanMonoid]]. */
trait EuclideanMonoidOps extends MultiplicativeMonoidOps:

  extension [X : EuclideanMonoid as X](x: X)

    /** Computes the quotient between both operands. */
    inline infix def / (y: X): X = X.divide(x, y)
