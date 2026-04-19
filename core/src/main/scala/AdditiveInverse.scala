package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.builder.AdditiveInverseBuilder
import com.alecdorrington.scalgebra.ops.AdditiveInverseOps

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
  * import com.alecdorrington.scalgebra.AdditiveInverse.{*, given}
  * ```
  * to receive all necessary syntax for working with additive inverses.
  */
object AdditiveInverse extends AdditiveInverseBuilder, AdditiveInverseOps:

  export com.alecdorrington.scalgebra.AdditiveInverse

  /** The [[AdditiveInverse]] instance describing the current algebra system. */
  inline def additiveInverse[X : AdditiveInverse as additiveInverse]
    : AdditiveInverse[X] = additiveInverse
