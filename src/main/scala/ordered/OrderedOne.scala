package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.MultiplicativeIdentity
import io.github.sgtswagrid.structures.ordered.builder.OrderedMultiplicativeIdentityBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedMultiplicativeIdentityOps

/** An ordered version of [[MultiplicativeIdentity]]. */
trait OrderedOne[X] extends MultiplicativeIdentity[X], Ordering[X]

/**
  * The companion object for [[OrderedOne]]. Import as
  * {{{
  * import io.github.sgtswagrid.structures.ordered.OrderedOne.{*, given}
  * }}}
  * to receive all necessary syntax for working with ordered one.
  */
object OrderedOne extends OrderedMultiplicativeIdentityBuilder, OrderedMultiplicativeIdentityOps:

  export io.github.sgtswagrid.structures.ordered.OrderedOne

  /** The [[OrderedOne]] instance describing the current algebra system. */
  inline def orderedOne[X : OrderedOne as orderedOne]: OrderedOne[X] =
    orderedOne
