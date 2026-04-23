package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[Pseudoring]]. */
trait OrderedPseudoring[X]
  extends Pseudoring[X],
          OrderedAdditiveGroup[X],
          OrderedMultiplicativeSemigroup[X]

/** The companion object for [[OrderedPseudoring]]. */
object OrderedPseudoring extends OrderedPseudoring.Ops:

  trait Ops
    extends Pseudoring.Ops,
            OrderedAdditiveGroup.Ops,
            OrderedMultiplicativeSemigroup.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedPseudoring

  /** The [[OrderedPseudoring]] instance describing the current algebra system. */
  inline def orderedPseudoring[X : OrderedPseudoring as orderedPseudoring]
    : OrderedPseudoring[X] = orderedPseudoring
