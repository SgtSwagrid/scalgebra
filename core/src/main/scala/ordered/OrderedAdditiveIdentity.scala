package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.AdditiveIdentity
import com.alecdorrington.scalgebra.ordered.builder.OrderedAdditiveIdentityBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedAdditiveIdentityOps

/** An ordered version of [[AdditiveIdentity]]. */
trait OrderedAdditiveIdentity[X] extends AdditiveIdentity[X], Ordering[X]:

  /** @return `true` if a value [[x]] is strictly positive, i.e. `x > 0`. */
  final inline def isPositive(x: X): Boolean = gt(x, zero)

  /** @return `true` if a value [[x]] is strictly negative, i.e. `x < 0`. */
  final inline def isNegative(x: X): Boolean = lt(x, zero)

  /** @return `true` if a value [[x]] is positive or [[zero]], i.e. `x ≥ 0`. */
  final inline def isNonNegative(x: X): Boolean = gteq(x, zero)

  /** @return `true` if a value [[x]] is negative or [[zero]], i.e. `x ≤ 0`. */
  final inline def isNonPositive(x: X): Boolean = lteq(x, zero)

/**
  * The companion object for [[OrderedAdditiveIdentity]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedAdditiveIdentity.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered additive identity.
  */
object OrderedAdditiveIdentity
  extends OrderedAdditiveIdentityBuilder, OrderedAdditiveIdentityOps:

  export com.alecdorrington.scalgebra.ordered.OrderedAdditiveIdentity

  /**
    * The [[OrderedAdditiveIdentity]] instance describing the current algebra
    * system.
    */
  inline def orderedAdditiveIdentity[
    X : OrderedAdditiveIdentity as orderedAdditiveIdentity,
  ]: OrderedAdditiveIdentity[X] = orderedAdditiveIdentity
