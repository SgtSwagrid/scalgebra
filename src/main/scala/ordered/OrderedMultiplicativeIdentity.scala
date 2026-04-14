package io.github.sgtswagrid.structures
package ordered

import io.github.sgtswagrid.structures.MultiplicativeIdentity
import io.github.sgtswagrid.structures.ordered.builder.OrderedMultiplicativeIdentityBuilder
import io.github.sgtswagrid.structures.ordered.ops.OrderedMultiplicativeIdentityOps

/** An ordered version of [[MultiplicativeIdentity]]. */
trait OrderedMultiplicativeIdentity[X]
  extends MultiplicativeIdentity[X], Ordering[X]

/**
  * The companion object for [[OrderedMultiplicativeIdentity]]. Import as
  * ```scala
  * import io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeIdentity.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered multiplicative
  * identity.
  */
object OrderedMultiplicativeIdentity
  extends OrderedMultiplicativeIdentityBuilder,
          OrderedMultiplicativeIdentityOps:

  export io.github.sgtswagrid.structures.ordered.OrderedMultiplicativeIdentity

  /**
    * The [[OrderedMultiplicativeIdentity]] instance describing the current
    * algebra system.
    */
  inline def orderedMultiplicativeIdentity[
    X : OrderedMultiplicativeIdentity as orderedMultiplicativeIdentity,
  ]: OrderedMultiplicativeIdentity[X] = orderedMultiplicativeIdentity
