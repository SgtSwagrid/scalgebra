package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[DifferenceSemigroup]]. */
trait OrderedDifferenceSemigroup[X]
  extends DifferenceSemigroup[X], OrderedAdditiveSemigroup[X]

/** The companion object for [[OrderedDifferenceSemigroup]]. */
object OrderedDifferenceSemigroup extends OrderedDifferenceSemigroup.Ops:

  trait Ops extends DifferenceSemigroup.Ops, OrderedAdditiveSemigroup.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemigroup

  /**
    * The [[OrderedDifferenceSemigroup]] instance describing the current algebra
    * system.
    */
  inline def orderedDifferenceSemigroup[
    X : OrderedDifferenceSemigroup as orderedDifferenceSemigroup,
  ]: OrderedDifferenceSemigroup[X] = orderedDifferenceSemigroup
