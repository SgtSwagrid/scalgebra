package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.builder.MultiplicativeIdentityBuilder
import com.alecdorrington.scalgebra.ops.MultiplicativeIdentityOps

/** For algebraic structures with a multiplicative identity (`one`). */
trait MultiplicativeIdentity[+X]:

  /**
    * The unique representation of the multiplicative identity (`1`) in this
    * algebra system. Typically corresponds to values such as `1` or `1.0F`.
    *
    * @note
    *   All implementations must obey the identity property, i.e.
    *   `x × one == one × x == x`.
    */
  def one: X

/**
  * The companion object for [[MultiplicativeIdentity]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.One.{*, given}
  * ```
  * to receive all necessary syntax for working with one.
  */
object MultiplicativeIdentity
  extends MultiplicativeIdentityBuilder, MultiplicativeIdentityOps:

  export com.alecdorrington.scalgebra.MultiplicativeIdentity

  /**
    * The [[MultiplicativeIdentity]] instance describing the current algebra
    * system.
    */
  inline def multiplicativeIdentity[X : MultiplicativeIdentity as one]
    : MultiplicativeIdentity[X] = one
