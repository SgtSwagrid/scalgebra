package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.Semifield
import com.alecdorrington.scalgebra.ordered.builder.OrderedSemifieldBuilder
import com.alecdorrington.scalgebra.ordered.ops.OrderedSemifieldOps

/** An ordered version of [[Semifield]]. */
trait OrderedSemifield[X]
  extends Semifield[X], OrderedSemiring[X], OrderedMultiplicativeGroup[X]

/**
  * The companion object for [[OrderedSemifield]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.ordered.OrderedSemifield.{*, given}
  * ```
  * to receive all necessary syntax for working with ordered semifields.
  */
object OrderedSemifield extends OrderedSemifieldBuilder, OrderedSemifieldOps:

  export com.alecdorrington.scalgebra.ordered.OrderedSemifield

  /** The [[OrderedSemifield]] instance describing the current algebra system. */
  inline def orderedSemifield[X : OrderedSemifield as orderedSemifield]
    : OrderedSemifield[X] = orderedSemifield
