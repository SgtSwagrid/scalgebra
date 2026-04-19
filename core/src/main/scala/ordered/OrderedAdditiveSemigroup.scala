package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.AdditiveSemigroup
import com.alecdorrington.scalgebra.ordered.builder.OrderedAdditiveSemigroupBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedAdditiveSemigroupOps

/** An ordered version of [[AdditiveSemigroup]]. */
trait OrderedAdditiveSemigroup[X] extends AdditiveSemigroup[X], Ordering[X]

/**
  * The companion object for [[OrderedAdditiveSemigroup]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedAdditiveSemigroup.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered additive
  * semigroups.
  */
object OrderedAdditiveSemigroup
  extends OrderedAdditiveSemigroupBuilder, OrderedAdditiveSemigroupOps:

  export com.alecdorrington.scalgebra.ordered.OrderedAdditiveSemigroup

  /**
    * The [[OrderedAdditiveSemigroup]] instance describing the current algebra
    * system.
    */
  inline def orderedAdditiveSemigroup[
    X : OrderedAdditiveSemigroup as orderedAdditiveSemigroup,
  ]: OrderedAdditiveSemigroup[X] = orderedAdditiveSemigroup
