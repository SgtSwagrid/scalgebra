package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[Semifield]]. */
trait OrderedSemifield[X]
  extends Semifield[X], OrderedSemiring[X], OrderedMultiplicativeGroup[X]

/** The companion object for [[OrderedSemifield]]. */
object OrderedSemifield extends OrderedSemifield.Ops:

  trait Ops
    extends Semifield.Ops, OrderedSemiring.Ops, OrderedMultiplicativeGroup.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedSemifield

  /** The [[OrderedSemifield]] instance describing the current algebra system. */
  inline def orderedSemifield[X : OrderedSemifield as orderedSemifield]
    : OrderedSemifield[X] = orderedSemifield
