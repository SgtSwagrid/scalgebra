package com.alecdorrington.scalgebra
package ordered

import scala.annotation.targetName

/** An ordered version of [[AdditiveIdentity]]. */
trait OrderedAdditiveIdentity[X] extends AdditiveIdentity[X], Order[X]:

  /** @return `true` if [[x]] is strictly positive, i.e. `x > 0`. */
  inline def isPositive(x: X): Boolean = gt(x, zero)

  /** @return `true` if [[x]] is strictly negative, i.e. `x < 0`. */
  inline def isNegative(x: X): Boolean = lt(x, zero)

  /** @return `true` if [[x]] is positive or [[zero]], i.e. `x ≥ 0`. */
  inline def isNonNegative(x: X): Boolean = gteq(x, zero)

  /** @return `true` if [[x]] is negative or [[zero]], i.e. `x ≤ 0`. */
  inline def isNonPositive(x: X): Boolean = lteq(x, zero)

  extension (x: X)

    /** @return `true` if [[x]] is strictly positive, i.e. `x > 0`. */
    @targetName("isPositive_postfix")
    inline def isPositive: Boolean = OrderedAdditiveIdentity.this.isPositive(x)

    /** @return `true` if [[x]] is strictly negative, i.e. `x < 0`. */
    @targetName("isNegative_postfix")
    inline def isNegative: Boolean = OrderedAdditiveIdentity.this.isNegative(x)

    /** @return `true` if [[x]] is positive or [[zero]], i.e. `x ≥ 0`. */
    @targetName("isNonNegative_postfix")
    inline def isNonNegative: Boolean = OrderedAdditiveIdentity.this
      .isNonNegative(x)

    /** @return `true` if [[x]] is negative or [[zero]], i.e. `x ≤ 0`. */
    @targetName("isNonPositive_postfix")
    inline def isNonPositive: Boolean = OrderedAdditiveIdentity.this
      .isNonPositive(x)

/** The companion object for [[OrderedAdditiveIdentity]]. */
object OrderedAdditiveIdentity extends OrderedAdditiveIdentity.Ops:

  trait Ops extends AdditiveIdentity.Ops:

    /** @return `true` if [[x]] is strictly positive, i.e. `x > 0`. */
    inline def isPositive[X : OrderedAdditiveIdentity as X](x: X): Boolean = X
      .isPositive(x)

    /** @return `true` if [[x]] is strictly negative, i.e. `x < 0`. */
    inline def isNegative[X : OrderedAdditiveIdentity as X](x: X): Boolean = X
      .isNegative(x)

    /** @return `true` if [[x]] is positive or [[zero]], i.e. `x ≥ 0`. */
    inline def isNonNegative[X : OrderedAdditiveIdentity as X](x: X): Boolean =
      X.isNonNegative(x)

    /** @return `true` if [[x]] is negative or [[zero]], i.e. `x ≤ 0`. */
    inline def isNonPositive[X : OrderedAdditiveIdentity as X](x: X): Boolean =
      X.isNonPositive(x)

  export com.alecdorrington.scalgebra.ordered.OrderedAdditiveIdentity

  /**
    * The [[OrderedAdditiveIdentity]] instance describing the current algebra
    * system.
    */
  inline def orderedAdditiveIdentity[
    X : OrderedAdditiveIdentity as orderedAdditiveIdentity,
  ]: OrderedAdditiveIdentity[X] = orderedAdditiveIdentity
