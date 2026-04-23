package com.alecdorrington.scalgebra
package ordered

import scala.annotation.targetName

/** For algebraic structures with a total order. */
trait Order[X] extends Ordering[X], Root[X]:

  /**
    * Clamps [[x]] to the inclusive range `[lb, ub]`.
    *
    * @return
    *   [[lb]] if [[x]] is less than [[lb]], [[ub]] if greater than [[ub]], or
    *   [[x]] otherwise.
    */
  inline def clamp(x: X, lb: X, ub: X): X =
    if compare(x, lb) < 0 then lb else if compare(x, ub) > 0 then ub else x

  extension (x: X)

    /** @return `true` if the left operand is smaller than the right. */
    inline infix def < (y: X): Boolean = compare(x, y) < 0

    /** @return `true` if the left operand is not larger than the right. */
    inline infix def <= (y: X): Boolean = compare(x, y) <= 0

    /** @return `true` if the right operand is larger than the left. */
    inline infix def > (y: X): Boolean = compare(x, y) > 0

    /** @return `true` if the right operand is not smaller than the left. */
    inline infix def >= (y: X): Boolean = compare(x, y) >= 0

    /** @return the smaller of both operands. */
    inline infix def min(y: X): X = if compare(x, y) <= 0 then x else y

    /** @return the larger of both operands. */
    inline infix def max(y: X): X = if compare(x, y) >= 0 then x else y

    /**
      * Clamps [[x]] to the inclusive range `[lb, ub]`.
      *
      * @return
      *   [[lb]] if [[x]] is less than [[lb]], [[ub]] if greater than [[ub]], or
      *   [[x]] otherwise.
      */
    @targetName("clamp_postfix")
    inline def clamp(lb: X, ub: X): X = Order.this.clamp(x, lb, ub)

/** The companion object for [[Order]]. */
object Order extends Order.Ops:

  trait Ops:

    /**
      * Clamps [[x]] to the inclusive range `[lb, ub]`.
      *
      * @return
      *   [[lb]] if [[x]] is less than [[lb]], [[ub]] if greater than [[ub]], or
      *   [[x]] otherwise.
      */
    inline def clamp[X : Order as X](x: X, lb: X, ub: X): X = X.clamp(x, lb, ub)

  export com.alecdorrington.scalgebra.ordered.Order

  /** The [[Order]] instance describing the current algebra system. */
  inline def order[X : Order as order]: Order[X] = order
