package com.alecdorrington.scalgebra
package ordered

/** An ordered version of [[AdditiveMonoid]]. */
trait OrderedAdditiveMonoid[X]
  extends AdditiveMonoid[X],
          OrderedAdditiveSemigroup[X],
          OrderedAdditiveIdentity[X]

/** The companion object for [[OrderedAdditiveMonoid]]. */
object OrderedAdditiveMonoid extends OrderedAdditiveMonoid.Ops:

  trait Ops
    extends AdditiveMonoid.Ops,
            OrderedAdditiveSemigroup.Ops,
            OrderedAdditiveIdentity.Ops

  /**
    * The [[OrderedAdditiveMonoid]] instance describing the current algebra
    * system.
    */
  inline def orderedAdditiveMonoid[
    X : OrderedAdditiveMonoid as orderedAdditiveMonoid,
  ]: OrderedAdditiveMonoid[X] = orderedAdditiveMonoid
