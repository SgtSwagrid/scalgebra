package com.alecdorrington.scalgebra
package ordered

import scala.annotation.targetName

/** An ordered version of [[AdditiveGroup]]. */
trait OrderedAdditiveGroup[X]
  extends AdditiveGroup[X],
          OrderedDifferenceMonoid[X],
          OrderedAdditiveInverse[X]:

  /** Computes the absolute value of a value [[x]], i.e. `|x|`. */
  inline def abs(x: X): X = if lt(x, zero) then negate(x) else x

  extension (x: X)

    /** Computes the absolute value of [[x]], i.e. `|x|`. */
    @targetName("abs_postfix")
    inline def abs: X = OrderedAdditiveGroup.this.abs(x)

/** The companion object for [[OrderedAdditiveGroup]]. */
object OrderedAdditiveGroup extends OrderedAdditiveGroup.Ops:

  trait Ops
    extends AdditiveGroup.Ops,
            OrderedDifferenceMonoid.Ops,
            OrderedAdditiveInverse.Ops:

    /** Computes the absolute value of a value [[x]], i.e. `|x|`. */
    inline def abs[X : OrderedAdditiveGroup as X](x: X): X = X.abs(x)

  export com.alecdorrington.scalgebra.ordered.OrderedAdditiveGroup

  /**
    * The [[OrderedAdditiveGroup]] instance describing the current algebra
    * system.
    */
  inline def orderedAdditiveGroup[
    X : OrderedAdditiveGroup as orderedAdditiveGroup,
  ]: OrderedAdditiveGroup[X] = orderedAdditiveGroup
