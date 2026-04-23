package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[Semiring]]. */
trait OrderedSemiring[X]
  extends Semiring[X], OrderedAdditiveMonoid[X], OrderedMultiplicativeMonoid[X]

/** The companion object for [[OrderedSemiring]]. */
object OrderedSemiring extends OrderedSemiring.Ops:

  trait Ops
    extends Semiring.Ops,
            OrderedAdditiveMonoid.Ops,
            OrderedMultiplicativeMonoid.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedSemiring

  /** The [[OrderedSemiring]] instance describing the current algebra system. */
  inline def orderedSemiring[X : OrderedSemiring as orderedSemiring]
    : OrderedSemiring[X] = orderedSemiring
