package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.MultiplicativeInverse
import io.github.sgtswagrid.structures.ordered.builder.OrderedMultiplicativeInverseBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedMultiplicativeInverseOps

/** An ordered version of [[MultiplicativeInverse]]. */
trait OrderedMultiplicativeInverse[X]
  extends MultiplicativeInverse[X], Ordering[X]

/**
  * The companion object for [[OrderedMultiplicativeInverse]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeInverse.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered multiplicative
  * inverses.
  */
object OrderedMultiplicativeInverse
  extends OrderedMultiplicativeInverseBuilder, OrderedMultiplicativeInverseOps:

  export io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeInverse

  /**
    * The [[OrderedMultiplicativeInverse]] instance describing the current
    * algebra system.
    */
  inline def orderedMultiplicativeInverse[
    X : OrderedMultiplicativeInverse as orderedMultiplicativeInverse,
  ]: OrderedMultiplicativeInverse[X] = orderedMultiplicativeInverse
