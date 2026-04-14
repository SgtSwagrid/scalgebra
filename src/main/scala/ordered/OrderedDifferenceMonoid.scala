package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.DifferenceMonoid
import io.github.sgtswagrid.structures.ordered.builder.OrderedDifferenceMonoidBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedDifferenceMonoidOps

/** An ordered version of [[DifferenceMonoid]]. */
trait OrderedDifferenceMonoid[X]
  extends DifferenceMonoid[X], OrderedAdditiveMonoid[X]

/**
  * The companion object for [[OrderedDifferenceMonoid]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.ordered.OrderedDifferenceMonoid.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered difference monoids.
  */
object OrderedDifferenceMonoid
  extends OrderedDifferenceMonoidBuilder, OrderedDifferenceMonoidOps:

  export io.github.sgtswagrid.structures.ordered.OrderedDifferenceMonoid

  /**
    * The [[OrderedDifferenceMonoid]] instance describing the current algebra
    * system.
    */
  inline def orderedDifferenceMonoid[
    X : OrderedDifferenceMonoid as orderedDifferenceMonoid,
  ]: OrderedDifferenceMonoid[X] = orderedDifferenceMonoid
