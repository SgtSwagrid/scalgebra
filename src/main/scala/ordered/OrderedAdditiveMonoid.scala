package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.AdditiveMonoid
import io.github.sgtswagrid.structures.ordered.builder.OrderedAdditiveMonoidBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedAdditiveMonoidOps

/** An ordered version of [[AdditiveMonoid]]. */
trait OrderedAdditiveMonoid[X]
  extends AdditiveMonoid[X], OrderedAdditiveSemigroup[X], OrderedAdditiveIdentity[X]

/**
  * The companion object for [[OrderedAdditiveMonoid]]. Import as
  * {{{
  * import io.github.sgtswagrid.structures.ordered.OrderedAdditiveMonoid.{*, given}
  * }}}
  * to receive all necessary syntax for working with ordered additive monoids.
  */
object OrderedAdditiveMonoid
  extends OrderedAdditiveMonoidBuilder, OrderedAdditiveMonoidOps:

  export io.github.sgtswagrid.structures.ordered.OrderedAdditiveMonoid

  /**
    * The [[OrderedAdditiveMonoid]] instance describing the current algebra
    * system.
    */
  inline def orderedAdditiveMonoid[
    X : OrderedAdditiveMonoid as orderedAdditiveMonoid,
  ]: OrderedAdditiveMonoid[X] = orderedAdditiveMonoid
