package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.EuclideanMonoid
import com.alecdorrington.scalgebra.ordered.builder.OrderedEuclideanMonoidBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedEuclideanMonoidOps

/** An ordered version of [[EuclideanMonoid]]. */
trait OrderedEuclideanMonoid[X]
  extends EuclideanMonoid[X], OrderedMultiplicativeMonoid[X]

/**
  * The companion object for [[OrderedEuclideanMonoid]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedEuclideanMonoid.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered Euclidean monoids.
  */
object OrderedEuclideanMonoid
  extends OrderedEuclideanMonoidBuilder, OrderedEuclideanMonoidOps:

  export com.alecdorrington.scalgebra.ordered.OrderedEuclideanMonoid

  /**
    * The [[OrderedEuclideanMonoid]] instance describing the current algebra
    * system.
    */
  inline def orderedEuclideanMonoid[
    X : OrderedEuclideanMonoid as orderedEuclideanMonoid,
  ]: OrderedEuclideanMonoid[X] = orderedEuclideanMonoid
