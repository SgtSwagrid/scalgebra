package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[DifferenceMonoid]]. */
trait OrderedDifferenceMonoid[X]
  extends DifferenceMonoid[X],
          OrderedDifferenceSemigroup[X],
          OrderedAdditiveMonoid[X]

/** The companion object for [[OrderedDifferenceMonoid]]. */
object OrderedDifferenceMonoid extends OrderedDifferenceMonoid.Ops:

  trait Ops
    extends DifferenceMonoid.Ops,
            OrderedDifferenceSemigroup.Ops,
            OrderedAdditiveMonoid.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedDifferenceMonoid

  /**
    * The [[OrderedDifferenceMonoid]] instance describing the current algebra
    * system.
    */
  inline def orderedDifferenceMonoid[
    X : OrderedDifferenceMonoid as orderedDifferenceMonoid,
  ]: OrderedDifferenceMonoid[X] = orderedDifferenceMonoid
