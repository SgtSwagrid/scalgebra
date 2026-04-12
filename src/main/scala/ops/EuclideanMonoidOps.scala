package io.github.sgtswagrid.structures
package ops

import io.github.sgtswagrid.structures.EuclideanMonoid

/** Extension methods for [[EuclideanMonoid]]. */
trait EuclideanMonoidOps extends MultiplicativeMonoidOps:

  extension [X : EuclideanMonoid as X](x: X)

    /** Computes the quotient between both operands. */
    inline infix def / (y: X): X = X.divide(x, y)
