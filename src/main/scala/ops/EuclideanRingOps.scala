package io.github.sgtswagrid.structures
package ops

import io.github.sgtswagrid.structures.EuclideanRing

/** Extension methods for [[EuclideanRing]]. */
trait EuclideanRingOps extends RingOps, EuclideanMonoidOps:

  extension [X : EuclideanRing as X](x: X)

    /** Computes the signed remainder between both operands. */
    inline infix def % (y: X): X = X.mod(x, y)
