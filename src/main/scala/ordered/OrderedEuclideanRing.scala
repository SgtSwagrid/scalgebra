package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.EuclideanRing
import io.github.sgtswagrid.structures.ordered.builder.OrderedEuclideanRingBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedEuclideanRingOps

/** An ordered version of [[EuclideanRing]]. */
trait OrderedEuclideanRing[X]
  extends EuclideanRing[X], OrderedRing[X], OrderedEuclideanMonoid[X]

/**
  * The companion object for [[OrderedEuclideanRing]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.ordered.OrderedEuclideanRing.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered Euclidean rings.
  */
object OrderedEuclideanRing
  extends OrderedEuclideanRingBuilder, OrderedEuclideanRingOps:

  export io.github.sgtswagrid.structures.ordered.OrderedEuclideanRing

  /**
    * The [[OrderedEuclideanRing]] instance describing the current algebra
    * system.
    */
  inline def orderedEuclideanRing[
    X : OrderedEuclideanRing as orderedEuclideanRing,
  ]: OrderedEuclideanRing[X] = orderedEuclideanRing
