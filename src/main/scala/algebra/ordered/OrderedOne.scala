package io.github.sgtswagrid.nonsense
package algebra.ordered

import io.github.sgtswagrid.nonsense.algebra.MultiplicativeIdentity
import io.github.sgtswagrid.nonsense.algebra.ordered.builder.OrderedOneBuilder
import io.github.sgtswagrid.nonsense.algebra.ordered.ops.OrderedOneOps

/** An ordered version of [[MultiplicativeIdentity]]. */
trait OrderedOne[X] extends MultiplicativeIdentity[X], Ordering[X]

/**
  * The companion object for [[OrderedOne]]. Import as
  * {{{
  * import io.github.sgtswagrid.nonsense.algebra.ordered.OrderedOne.{*, given}
  * }}}
  * to receive all necessary syntax for working with ordered one.
  */
object OrderedOne extends OrderedOneBuilder, OrderedOneOps:

  export io.github.sgtswagrid.nonsense.algebra.ordered.OrderedOne

  /** The [[OrderedOne]] instance describing the current algebra system. */
  inline def orderedOne[X : OrderedOne as orderedOne]: OrderedOne[X] =
    orderedOne
