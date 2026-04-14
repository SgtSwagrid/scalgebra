package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.AdditiveSemigroup
import io.github.sgtswagrid.structures.ordered.builder.OrderedAdditiveSemigroupBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedAdditiveSemigroupOps

/** An ordered version of [[AdditiveSemigroup]]. */
trait OrderedAdditiveSemigroup[X] extends AdditiveSemigroup[X], Ordering[X]

/**
  * The companion object for [[OrderedAdditiveSemigroup]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.ordered.OrderedAdditiveSemigroup.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered additive
  * semigroups.
  */
object OrderedAdditiveSemigroup
  extends OrderedAdditiveSemigroupBuilder, OrderedAdditiveSemigroupOps:

  export io.github.sgtswagrid.structures.ordered.OrderedAdditiveSemigroup

  /**
    * The [[OrderedAdditiveSemigroup]] instance describing the current algebra
    * system.
    */
  inline def orderedAdditiveSemigroup[
    X : OrderedAdditiveSemigroup as orderedAdditiveSemigroup,
  ]: OrderedAdditiveSemigroup[X] = orderedAdditiveSemigroup
