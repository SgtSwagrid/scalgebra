package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.MultiplicativeSemigroup
import io.github.sgtswagrid.structures.ordered.builder.OrderedMultiplicativeSemigroupBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedMultiplicativeSemigroupOps

/** An ordered version of [[MultiplicativeSemigroup]]. */
trait OrderedMultiplicativeSemigroup[X]
  extends MultiplicativeSemigroup[X], Ordering[X]

/**
  * The companion object for [[OrderedMultiplicativeSemigroup]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeSemigroup.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered multiplicative
  * semigroups.
  */
object OrderedMultiplicativeSemigroup
  extends OrderedMultiplicativeSemigroupBuilder,
          OrderedMultiplicativeSemigroupOps:

  export io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeSemigroup

  /**
    * The [[OrderedMultiplicativeSemigroup]] instance describing the current
    * algebra system.
    */
  inline def orderedMultiplicativeSemigroup[
    X : OrderedMultiplicativeSemigroup as orderedMultiplicativeSemigroup,
  ]: OrderedMultiplicativeSemigroup[X] = orderedMultiplicativeSemigroup
