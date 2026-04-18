package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.AdditiveGroup
import com.alecdorrington.scalgebra.ordered.builder.OrderedAdditiveGroupBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedAdditiveGroupOps

/** An ordered version of [[AdditiveGroup]]. */
trait OrderedAdditiveGroup[X]
  extends AdditiveGroup[X],
          OrderedDifferenceMonoid[X],
          OrderedAdditiveInverse[X]:

  /** Computes the absolute value of a value [[x]]. */
  def abs(x: X): X = if isNegative(x) then negate(x) else x

/**
  * The companion object for [[OrderedAdditiveGroup]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedAdditiveGroup.{*, given}
  * ```
  * to receive all necessary syntax for working with ordered additive groups.
  */
object OrderedAdditiveGroup
  extends OrderedAdditiveGroupBuilder, OrderedAdditiveGroupOps:

  export com.alecdorrington.scalgebra.ordered.OrderedAdditiveGroup

  /**
    * The [[OrderedAdditiveGroup]] instance describing the current algebra
    * system.
    */
  inline def orderedAdditiveGroup[
    X : OrderedAdditiveGroup as orderedAdditiveGroup,
  ]: OrderedAdditiveGroup[X] = orderedAdditiveGroup
