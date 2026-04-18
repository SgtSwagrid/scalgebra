package com.alecdorrington.scalgebra
package ops

import com.alecdorrington.scalgebra.AdditiveInverse

/** Extension methods for [[AdditiveInverse]]. */
trait AdditiveInverseOps:

  extension [X : AdditiveInverse as X](x: X)

    /** Computes the additive inverse (negative) of this value. */
    inline def unary_- : X = X.negate(x)
