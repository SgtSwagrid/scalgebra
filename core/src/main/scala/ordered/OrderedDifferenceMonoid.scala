package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.DifferenceMonoid
import com.alecdorrington.scalgebra.ordered.builder.OrderedDifferenceMonoidBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedDifferenceMonoidOps

/** An ordered version of [[DifferenceMonoid]]. */
trait OrderedDifferenceMonoid[X]
  extends DifferenceMonoid[X], OrderedAdditiveMonoid[X]

/**
  * The companion object for [[OrderedDifferenceMonoid]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedDifferenceMonoid.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered difference monoids.
  */
object OrderedDifferenceMonoid
  extends OrderedDifferenceMonoidBuilder, OrderedDifferenceMonoidOps:

  export com.alecdorrington.scalgebra.ordered.OrderedDifferenceMonoid

  /**
    * The [[OrderedDifferenceMonoid]] instance describing the current algebra
    * system.
    */
  inline def orderedDifferenceMonoid[
    X : OrderedDifferenceMonoid as orderedDifferenceMonoid,
  ]: OrderedDifferenceMonoid[X] = orderedDifferenceMonoid
