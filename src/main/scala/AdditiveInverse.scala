package io.github.sgtswagrid.structures

import io.github.sgtswagrid.structures.builder.AdditiveInverseBuilder
import io.github.sgtswagrid.structures.ops.AdditiveInverseOps

/** For algebraic structures with an additive inverse. */
trait AdditiveInverse[X]:

  /**
    * Computes the additive inverse (negative) of a value [[x]], i.e. `-x`.
    *
    * @note
    *   All implementations must be involutions, i.e. `negate(negate(x)) == x`.
    */
  def negate(x: X): X

/**
  * The companion object for [[AdditiveInverse]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.AdditiveInverse.{*, given}
  * ```
  * to receive all necessary syntax for working with additive inverses.
  */
object AdditiveInverse extends AdditiveInverseBuilder, AdditiveInverseOps:

  export io.github.sgtswagrid.structures.AdditiveInverse

  /** The [[AdditiveInverse]] instance describing the current algebra system. */
  inline def additiveInverse[X : AdditiveInverse as additiveInverse]
    : AdditiveInverse[X] = additiveInverse
