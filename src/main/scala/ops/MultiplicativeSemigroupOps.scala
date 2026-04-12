package io.github.sgtswagrid.structures
package ops

import io.github.sgtswagrid.structures.MultiplicativeSemigroup

/** Extension methods for [[MultiplicativeSemigroup]]. */
trait MultiplicativeSemigroupOps:

  extension [X : MultiplicativeSemigroup as X](x: X)

    /** Computes the product of both operands. */
    inline infix def * (y: X): X = X.multiply(x, y)

    /**
      * Computes this value raised to the power [[n]], for any strictly positive
      * [[n]].
      */
    inline infix def pow(n: Int): X = X.pow(x, n)
