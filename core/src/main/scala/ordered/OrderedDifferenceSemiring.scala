package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[DifferenceSemiring]]. */
trait OrderedDifferenceSemiring[X]
  extends DifferenceSemiring[X], OrderedSemiring[X], OrderedDifferenceMonoid[X]

/** The companion object for [[OrderedDifferenceSemiring]]. */
object OrderedDifferenceSemiring extends OrderedDifferenceSemiring.Ops:

  trait Ops
    extends DifferenceSemiring.Ops,
            OrderedSemiring.Ops,
            OrderedDifferenceMonoid.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemiring

  /**
    * The [[OrderedDifferenceSemiring]] instance describing the current algebra
    * system.
    */
  inline def orderedDifferenceSemiring[
    X : OrderedDifferenceSemiring as orderedDifferenceSemiring,
  ]: OrderedDifferenceSemiring[X] = orderedDifferenceSemiring
