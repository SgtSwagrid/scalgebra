package io.github.sgtswagrid.structures
package ops

import io.github.sgtswagrid.structures.MultiplicativeInverse

/** Extension methods for [[MultiplicativeInverse]]. */
trait MultiplicativeInverseOps:

  extension [X : MultiplicativeInverse as X](x: X)

    /** Computes the multiplicative inverse (reciprocal) of this value. */
    inline def reciprocal: X = X.reciprocate(x)
