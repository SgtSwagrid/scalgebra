package com.alecdorrington.scalgebra

import scala.annotation.targetName

/** For algebraic structures with an additive identity (`zero`). */
trait AdditiveIdentity[X] extends Root[X]:

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

  /** @return `true` if [[x]] equals [[zero]]. */
  inline def isZero(x: X): Boolean = x == zero

  extension (x: X)

    /** @return `true` if [[x]] equals [[zero]]. */
    @targetName("isZero_postfix")
    inline def isZero: Boolean = AdditiveIdentity.this.isZero(x)

/** The companion object for [[AdditiveIdentity]]. */
object AdditiveIdentity extends AdditiveIdentity.Ops:

  trait Ops:

    /**
      * The unique representation of the additive identity (`0`) in this algebra
      * system. Typically corresponds to values such as `0`, `0.0F`, or
      * `Seq.empty`.
      *
      * @note
      *   All implementations must obey the identity property, i.e.
      *   `x + zero == zero + x == x`.
      */
    inline def zero[X : AdditiveIdentity as X]: X = X.zero

    /** @return `true` if [[x]] equals [[zero]]. */
    inline def isZero[X : AdditiveIdentity as X](x: X): Boolean = X.isZero(x)

  export com.alecdorrington.scalgebra.AdditiveIdentity

  /** The [[AdditiveIdentity]] instance describing the current algebra system. */
  inline def additiveIdentity[X : AdditiveIdentity as zero]
    : AdditiveIdentity[X] = zero
