package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[EuclideanSemigroup]]. */
trait OrderedEuclideanSemigroup[X]
  extends EuclideanSemigroup[X], OrderedMultiplicativeSemigroup[X]

/** The companion object for [[OrderedEuclideanSemigroup]]. */
object OrderedEuclideanSemigroup extends OrderedEuclideanSemigroup.Ops:

  trait Ops extends EuclideanSemigroup.Ops, OrderedMultiplicativeSemigroup.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedEuclideanSemigroup

  /**
    * The [[OrderedEuclideanSemigroup]] instance describing the current algebra
    * system.
    */
  inline def orderedEuclideanSemigroup[
    X : OrderedEuclideanSemigroup as orderedEuclideanSemigroup,
  ]: OrderedEuclideanSemigroup[X] = orderedEuclideanSemigroup
