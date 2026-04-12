package io.github.sgtswagrid.structures
package ops

import io.github.sgtswagrid.structures.AdditiveMonoid

/** Extension methods for [[AdditiveMonoid]]. */
trait AdditiveMonoidOps extends AdditiveSemigroupOps, AdditiveIdentityOps:

  extension [X : AdditiveMonoid as X](x: X)

    /**
      * Multiplies this value on the left by a non-negative integer.
      *
      * @throws IllegalArgumentException
      *   if `n < 0`.
      */
    inline infix def *: (n: Int): X = X.scale(x, n)

    /**
      * Multiplies this value on the right by a non-negative integer.
      *
      * @throws IllegalArgumentException
      *   if `n < 0`.
      */
    inline infix def :* (n: Int): X = X.scale(x, n)
