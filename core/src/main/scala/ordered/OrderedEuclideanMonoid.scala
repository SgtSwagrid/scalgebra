package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[EuclideanMonoid]]. */
trait OrderedEuclideanMonoid[X]
  extends EuclideanMonoid[X],
          OrderedEuclideanSemigroup[X],
          OrderedMultiplicativeMonoid[X]

/** The companion object for [[OrderedEuclideanMonoid]]. */
object OrderedEuclideanMonoid extends OrderedEuclideanMonoid.Ops:

  trait Ops
    extends EuclideanMonoid.Ops,
            OrderedEuclideanSemigroup.Ops,
            OrderedMultiplicativeMonoid.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedEuclideanMonoid

  /**
    * The [[OrderedEuclideanMonoid]] instance describing the current algebra
    * system.
    */
  inline def orderedEuclideanMonoid[
    X : OrderedEuclideanMonoid as orderedEuclideanMonoid,
  ]: OrderedEuclideanMonoid[X] = orderedEuclideanMonoid
