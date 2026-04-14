package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.Semiring
import io.github.sgtswagrid.structures.ordered.builder.OrderedSemiringBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedSemiringOps

/** An ordered version of [[Semiring]]. */
trait OrderedSemiring[X]
  extends Semiring[X], OrderedAdditiveMonoid[X], OrderedMultiplicativeMonoid[X]

/**
  * The companion object for [[OrderedSemiring]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.ordered.OrderedSemiring.{*, given}
  * ```
  * to receive all necessary syntax for working with ordered semirings.
  */
object OrderedSemiring extends OrderedSemiringBuilder, OrderedSemiringOps:

  export io.github.sgtswagrid.structures.ordered.OrderedSemiring

  /** The [[OrderedSemiring]] instance describing the current algebra system. */
  inline def orderedSemiring[X : OrderedSemiring as orderedSemiring]
    : OrderedSemiring[X] = orderedSemiring
