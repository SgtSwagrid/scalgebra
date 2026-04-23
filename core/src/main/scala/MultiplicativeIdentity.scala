package com.alecdorrington.scalgebra

import scala.annotation.targetName

/** For algebraic structures with a multiplicative identity (`one`). */
trait MultiplicativeIdentity[X] extends Root[X]:

  /**
    * The unique representation of the multiplicative identity (`1`) in this
    * algebra system. Typically corresponds to values such as `1` or `1.0F`.
    *
    * @note
    *   All implementations must obey the identity property, i.e.
    *   `x × one == one × x == x`.
    */
  def one: X

  /** @return `true` if [[x]] equals [[one]]. */
  inline def isOne(x: X): Boolean = x == one

  extension (x: X)

    /** @return `true` if [[x]] equals [[one]]. */
    @targetName("isOne_postfix")
    inline def isOne: Boolean = MultiplicativeIdentity.this.isOne(x)

/** The companion object for [[MultiplicativeIdentity]]. */
object MultiplicativeIdentity extends MultiplicativeIdentity.Ops:

  trait Ops:

    /**
      * The unique representation of the multiplicative identity (`1`) in this
      * algebra system. Typically corresponds to values such as `1` or `1.0F`.
      *
      * @note
      *   All implementations must obey the identity property, i.e.
      *   `x × one == one × x == x`.
      */
    inline def one[X : MultiplicativeIdentity as X]: X = X.one

    /** @return `true` if [[x]] equals [[one]]. */
    inline def isOne[X : MultiplicativeIdentity as X](x: X): Boolean =
      X.isOne(x)

  export com.alecdorrington.scalgebra.MultiplicativeIdentity

  /**
    * The [[MultiplicativeIdentity]] instance describing the current algebra
    * system.
    */
  inline def multiplicativeIdentity[X : MultiplicativeIdentity as one]
    : MultiplicativeIdentity[X] = one
