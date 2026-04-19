package com.alecdorrington.scalgebra
package ops

import com.alecdorrington.scalgebra.MultiplicativeInverse

/** Extension methods for [[MultiplicativeInverse]]. */
trait MultiplicativeInverseOps:

  extension [X : MultiplicativeInverse as X](x: X)

    /** Computes the multiplicative inverse (reciprocal) of this value. */
    inline def reciprocal: X = X.reciprocate(x)
