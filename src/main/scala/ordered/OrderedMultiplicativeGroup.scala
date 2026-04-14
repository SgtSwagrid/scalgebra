package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.MultiplicativeGroup
import io.github.sgtswagrid.structures.ordered.builder.OrderedMultiplicativeGroupBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedMultiplicativeGroupOps

/** An ordered version of [[MultiplicativeGroup]]. */
trait OrderedMultiplicativeGroup[X]
  extends MultiplicativeGroup[X],
          OrderedEuclideanMonoid[X],
          OrderedMultiplicativeInverse[X]

/**
  * The companion object for [[OrderedMultiplicativeGroup]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeGroup.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered multiplicative
  * groups.
  */
object OrderedMultiplicativeGroup
  extends OrderedMultiplicativeGroupBuilder, OrderedMultiplicativeGroupOps:

  export io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeGroup

  /**
    * The [[OrderedMultiplicativeGroup]] instance describing the current algebra
    * system.
    */
  inline def orderedMultiplicativeGroup[
    X : OrderedMultiplicativeGroup as orderedMultiplicativeGroup,
  ]: OrderedMultiplicativeGroup[X] = orderedMultiplicativeGroup
