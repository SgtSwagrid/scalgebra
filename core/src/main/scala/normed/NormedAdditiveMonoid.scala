package com.alecdorrington.scalgebra
package normed

/** A normed version of [[AdditiveMonoid]]. */
trait NormedAdditiveMonoid[X, S]
  extends AdditiveMonoid[X],
          NormedAdditiveSemigroup[X, S],
          NormedAdditiveIdentity[X, S]

/** The companion object for [[NormedAdditiveMonoid]]. */
object NormedAdditiveMonoid extends NormedAdditiveMonoid.Ops:

  trait Ops
    extends AdditiveMonoid.Ops,
            NormedAdditiveSemigroup.Ops,
            NormedAdditiveIdentity.Ops

  type Over[S] = [X] =>> NormedAdditiveMonoid[X, S]

  export com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

  /**
    * The [[NormedAdditiveMonoid]] instance describing the current algebra
    * system.
    */
  inline def normedAdditiveMonoid[X, S]
    (using ev: NormedAdditiveMonoid[X, S])
    : NormedAdditiveMonoid[X, S] = ev
