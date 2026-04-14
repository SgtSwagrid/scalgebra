package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.AdditiveInverse
import io.github.sgtswagrid.structures.ordered.builder.OrderedAdditiveInverseBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedAdditiveInverseOps

/** An ordered version of [[AdditiveInverse]]. */
trait OrderedAdditiveInverse[X] extends AdditiveInverse[X], Ordering[X]

/**
  * The companion object for [[OrderedAdditiveInverse]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.ordered.OrderedAdditiveInverse.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered additive inverses.
  */
object OrderedAdditiveInverse
  extends OrderedAdditiveInverseBuilder, OrderedAdditiveInverseOps:

  export io.github.sgtswagrid.structures.ordered.OrderedAdditiveInverse

  /**
    * The [[OrderedAdditiveInverse]] instance describing the current algebra
    * system.
    */
  inline def orderedAdditiveInverse[
    X : OrderedAdditiveInverse as orderedAdditiveInverse,
  ]: OrderedAdditiveInverse[X] = orderedAdditiveInverse
