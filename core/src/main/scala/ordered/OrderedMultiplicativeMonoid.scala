package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[MultiplicativeMonoid]]. */
trait OrderedMultiplicativeMonoid[X]
  extends MultiplicativeMonoid[X],
          OrderedMultiplicativeSemigroup[X],
          OrderedMultiplicativeIdentity[X]

/** The companion object for [[OrderedMultiplicativeMonoid]]. */
object OrderedMultiplicativeMonoid extends OrderedMultiplicativeMonoid.Ops:

  trait Ops
    extends MultiplicativeMonoid.Ops,
            OrderedMultiplicativeSemigroup.Ops,
            OrderedMultiplicativeIdentity.Ops

  export com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeMonoid

  /**
    * The [[OrderedMultiplicativeMonoid]] instance describing the current
    * algebra system.
    */
  inline def orderedMultiplicativeMonoid[
    X : OrderedMultiplicativeMonoid as orderedMultiplicativeMonoid,
  ]: OrderedMultiplicativeMonoid[X] = orderedMultiplicativeMonoid
