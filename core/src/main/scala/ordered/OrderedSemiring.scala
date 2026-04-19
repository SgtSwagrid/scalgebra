package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.Semiring
import com.alecdorrington.scalgebra.ordered.builder.OrderedSemiringBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedSemiringOps

/** An ordered version of [[Semiring]]. */
trait OrderedSemiring[X]
  extends Semiring[X], OrderedAdditiveMonoid[X], OrderedMultiplicativeMonoid[X]

/**
  * The companion object for [[OrderedSemiring]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedSemiring.{*, given}
  * ```
  * to receive all necessary syntax for working with ordered semirings.
  */
object OrderedSemiring extends OrderedSemiringBuilder, OrderedSemiringOps:

  export com.alecdorrington.scalgebra.ordered.OrderedSemiring

  /** The [[OrderedSemiring]] instance describing the current algebra system. */
  inline def orderedSemiring[X : OrderedSemiring as orderedSemiring]
    : OrderedSemiring[X] = orderedSemiring
