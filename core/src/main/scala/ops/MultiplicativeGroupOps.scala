package com.alecdorrington.scalgebra
package ops

import com.alecdorrington.scalgebra.MultiplicativeGroup

/** Extension methods for [[MultiplicativeGroup]]. */
trait MultiplicativeGroupOps
  extends EuclideanMonoidOps, MultiplicativeInverseOps:

  extension [X : MultiplicativeGroup as X](x: X)

    /** Computes this value raised to the power [[n]], for any integer [[n]]. */
    inline infix def pow(n: Int): X = X.pow(x, n)
