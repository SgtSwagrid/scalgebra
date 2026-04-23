package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[AdditiveSemigroup]]. */
trait OrderedAdditiveSemigroup[X] extends AdditiveSemigroup[X], Order[X]

/** The companion object for [[OrderedAdditiveSemigroup]]. */
object OrderedAdditiveSemigroup extends OrderedAdditiveSemigroup.Ops:

  trait Ops extends AdditiveSemigroup.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedAdditiveSemigroup

  /**
    * The [[OrderedAdditiveSemigroup]] instance describing the current algebra
    * system.
    */
  inline def orderedAdditiveSemigroup[
    X : OrderedAdditiveSemigroup as orderedAdditiveSemigroup,
  ]: OrderedAdditiveSemigroup[X] = orderedAdditiveSemigroup
