package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.MultiplicativeMonoid
import io.github.sgtswagrid.structures.ordered.builder.OrderedMultiplicativeMonoidBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedMultiplicativeMonoidOps

/** An ordered version of [[MultiplicativeMonoid]]. */
trait OrderedMultiplicativeMonoid[X]
  extends MultiplicativeMonoid[X],
          OrderedMultiplicativeSemigroup[X],
          OrderedMultiplicativeIdentity[X]

/**
  * The companion object for [[OrderedMultiplicativeMonoid]]. Import as
  * {{{
  * import io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeMonoid.{*, given}
  * }}}
  * to receive all necessary syntax for working with ordered multiplicative
  * monoids.
  */
object OrderedMultiplicativeMonoid
  extends OrderedMultiplicativeMonoidBuilder, OrderedMultiplicativeMonoidOps:

  export io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeMonoid

  /**
    * The [[OrderedMultiplicativeMonoid]] instance describing the current
    * algebra system.
    */
  inline def orderedMultiplicativeMonoid[
    X : OrderedMultiplicativeMonoid as orderedMultiplicativeMonoid,
  ]: OrderedMultiplicativeMonoid[X] = orderedMultiplicativeMonoid
