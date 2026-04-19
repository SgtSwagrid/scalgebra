package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.DifferenceSemiring
import com.alecdorrington.scalgebra.ordered.builder.OrderedDifferenceSemiringBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedDifferenceSemiringOps

/** An ordered version of [[DifferenceSemiring]]. */
trait OrderedDifferenceSemiring[X]
  extends DifferenceSemiring[X], OrderedSemiring[X], OrderedDifferenceMonoid[X]

/**
  * The companion object for [[OrderedDifferenceSemiring]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemiring.{
  *   *, given,
  * }
  * ```
  * to receive all necessary syntax for working with ordered difference
  * semirings.
  */
object OrderedDifferenceSemiring
  extends OrderedDifferenceSemiringBuilder, OrderedDifferenceSemiringOps:

  export com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemiring

  /**
    * The [[OrderedDifferenceSemiring]] instance describing the current algebra
    * system.
    */
  inline def orderedDifferenceSemiring[
    X : OrderedDifferenceSemiring as orderedDifferenceSemiring,
  ]: OrderedDifferenceSemiring[X] = orderedDifferenceSemiring
