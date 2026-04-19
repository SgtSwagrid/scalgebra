package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.builder.MultiplicativeInverseBuilder
import com.alecdorrington.scalgebra.ops.MultiplicativeInverseOps

/** For algebraic structures with a multiplicative inverse. */
trait MultiplicativeInverse[X]:

  /**
    * Computes the multiplicative inverse (reciprocal) of a value [[x]], i.e.
    * `1 / x`.
    *
    * @note
    *   All implementations must be involutions, i.e.
    *   `reciprocate(reciprocate(x)) == x`.
    */
  def reciprocate(x: X): X

/**
  * The companion object for [[MultiplicativeInverse]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.MultiplicativeInverse.{*, given}
  * ```
  * to receive all necessary syntax for working with multiplicative inverses.
  */
object MultiplicativeInverse
  extends MultiplicativeInverseBuilder, MultiplicativeInverseOps:

  export com.alecdorrington.scalgebra.MultiplicativeInverse

  /**
    * The [[MultiplicativeInverse]] instance describing the current algebra
    * system.
    */
  inline def multiplicativeInverse[
    X : MultiplicativeInverse as multiplicativeInverse,
  ]: MultiplicativeInverse[X] = multiplicativeInverse
