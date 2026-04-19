package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.builder.AdditiveIdentityBuilder
import com.alecdorrington.scalgebra.ops.AdditiveIdentityOps

/** For algebraic structures with an additive identity (`zero`). */
trait AdditiveIdentity[+X]:

  /**
    * The unique representation of the additive identity (`0`) in this algebra
    * system. Typically corresponds to values such as `0`, `0.0F`, or
    * `Seq.empty`.
    *
    * @note
    *   All implementations must obey the identity property, i.e.
    *   `x + zero == zero + x == x`.
    */
  def zero: X

/**
  * The companion object for [[AdditiveIdentity]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.Zero.{*, given}
  * ```
  * to receive all necessary syntax for working with zero.
  */
object AdditiveIdentity extends AdditiveIdentityBuilder, AdditiveIdentityOps:

  export com.alecdorrington.scalgebra.AdditiveIdentity

  /** The [[AdditiveIdentity]] instance describing the current algebra system. */
  inline def additiveIdentity[X : AdditiveIdentity as zero]
    : AdditiveIdentity[X] = zero
