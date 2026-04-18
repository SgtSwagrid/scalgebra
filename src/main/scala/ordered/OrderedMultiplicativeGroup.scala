package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.MultiplicativeGroup
import com.alecdorrington.scalgebra.ordered.builder.OrderedMultiplicativeGroupBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedMultiplicativeGroupOps

/** An ordered version of [[MultiplicativeGroup]]. */
trait OrderedMultiplicativeGroup[X]
  extends MultiplicativeGroup[X],
          OrderedEuclideanMonoid[X],
          OrderedMultiplicativeInverse[X]

/**
  * The companion object for [[OrderedMultiplicativeGroup]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeGroup.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered multiplicative
  * groups.
  */
object OrderedMultiplicativeGroup
  extends OrderedMultiplicativeGroupBuilder, OrderedMultiplicativeGroupOps:

  export com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeGroup

  /**
    * The [[OrderedMultiplicativeGroup]] instance describing the current algebra
    * system.
    */
  inline def orderedMultiplicativeGroup[
    X : OrderedMultiplicativeGroup as orderedMultiplicativeGroup,
  ]: OrderedMultiplicativeGroup[X] = orderedMultiplicativeGroup
