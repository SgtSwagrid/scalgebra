package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.AdditiveMonoid
import com.alecdorrington.scalgebra.ordered.builder.OrderedAdditiveMonoidBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedAdditiveMonoidOps

/** An ordered version of [[AdditiveMonoid]]. */
trait OrderedAdditiveMonoid[X]
  extends AdditiveMonoid[X],
          OrderedAdditiveSemigroup[X],
          OrderedAdditiveIdentity[X]

/**
  * The companion object for [[OrderedAdditiveMonoid]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedAdditiveMonoid.{*, given}
  * ```
  * to receive all necessary syntax for working with ordered additive monoids.
  */
object OrderedAdditiveMonoid
  extends OrderedAdditiveMonoidBuilder, OrderedAdditiveMonoidOps:

  export com.alecdorrington.scalgebra.ordered.OrderedAdditiveMonoid

  /**
    * The [[OrderedAdditiveMonoid]] instance describing the current algebra
    * system.
    */
  inline def orderedAdditiveMonoid[
    X : OrderedAdditiveMonoid as orderedAdditiveMonoid,
  ]: OrderedAdditiveMonoid[X] = orderedAdditiveMonoid
