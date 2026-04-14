package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.DifferenceSemiring
import io.github.sgtswagrid.structures.ordered.builder.OrderedDifferenceSemiringBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedDifferenceSemiringOps

/** An ordered version of [[DifferenceSemiring]]. */
trait OrderedDifferenceSemiring[X]
  extends DifferenceSemiring[X], OrderedSemiring[X], OrderedDifferenceMonoid[X]

/**
  * The companion object for [[OrderedDifferenceSemiring]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.ordered.OrderedDifferenceSemiring.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered difference
  * semirings.
  */
object OrderedDifferenceSemiring
  extends OrderedDifferenceSemiringBuilder, OrderedDifferenceSemiringOps:

  export io.github.sgtswagrid.structures.ordered.OrderedDifferenceSemiring

  /**
    * The [[OrderedDifferenceSemiring]] instance describing the current algebra
    * system.
    */
  inline def orderedDifferenceSemiring[
    X : OrderedDifferenceSemiring as orderedDifferenceSemiring,
  ]: OrderedDifferenceSemiring[X] = orderedDifferenceSemiring
