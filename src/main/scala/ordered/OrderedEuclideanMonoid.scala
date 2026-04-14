package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.EuclideanMonoid
import io.github.sgtswagrid.structures.ordered.builder.OrderedEuclideanMonoidBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedEuclideanMonoidOps

/** An ordered version of [[EuclideanMonoid]]. */
trait OrderedEuclideanMonoid[X]
  extends EuclideanMonoid[X], OrderedMultiplicativeMonoid[X]

/**
  * The companion object for [[OrderedEuclideanMonoid]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.ordered.OrderedEuclideanMonoid.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered Euclidean monoids.
  */
object OrderedEuclideanMonoid
  extends OrderedEuclideanMonoidBuilder, OrderedEuclideanMonoidOps:

  export io.github.sgtswagrid.structures.ordered.OrderedEuclideanMonoid

  /**
    * The [[OrderedEuclideanMonoid]] instance describing the current algebra
    * system.
    */
  inline def orderedEuclideanMonoid[
    X : OrderedEuclideanMonoid as orderedEuclideanMonoid,
  ]: OrderedEuclideanMonoid[X] = orderedEuclideanMonoid
