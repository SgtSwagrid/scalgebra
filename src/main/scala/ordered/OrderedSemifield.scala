package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.Semifield
import io.github.sgtswagrid.structures.ordered.builder.OrderedSemifieldBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedSemifieldOps

/** An ordered version of [[Semifield]]. */
trait OrderedSemifield[X]
  extends Semifield[X], OrderedSemiring[X], OrderedMultiplicativeGroup[X]

/**
  * The companion object for [[OrderedSemifield]]. Import as
  * {{{
  * import io.github.sgtswagrid.structures.ordered.OrderedSemifield.{*, given}
  * }}}
  * to receive all necessary syntax for working with ordered semifields.
  */
object OrderedSemifield extends OrderedSemifieldBuilder, OrderedSemifieldOps:

  export io.github.sgtswagrid.structures.ordered.OrderedSemifield

  /** The [[OrderedSemifield]] instance describing the current algebra system. */
  inline def orderedSemifield[X : OrderedSemifield as orderedSemifield]
    : OrderedSemifield[X] = orderedSemifield
