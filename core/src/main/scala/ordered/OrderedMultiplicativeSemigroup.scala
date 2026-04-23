package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[MultiplicativeSemigroup]]. */
trait OrderedMultiplicativeSemigroup[X]
  extends MultiplicativeSemigroup[X], Order[X]

/** The companion object for [[OrderedMultiplicativeSemigroup]]. */
object OrderedMultiplicativeSemigroup
  extends OrderedMultiplicativeSemigroup.Ops:

  trait Ops extends MultiplicativeSemigroup.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeSemigroup

  /**
    * The [[OrderedMultiplicativeSemigroup]] instance describing the current
    * algebra system.
    */
  inline def orderedMultiplicativeSemigroup[
    X : OrderedMultiplicativeSemigroup as orderedMultiplicativeSemigroup,
  ]: OrderedMultiplicativeSemigroup[X] = orderedMultiplicativeSemigroup
