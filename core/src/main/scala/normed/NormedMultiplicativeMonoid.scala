package com.alecdorrington.scalgebra
package normed

/** A normed version of [[MultiplicativeMonoid]]. */
trait NormedMultiplicativeMonoid[X, S]
  extends MultiplicativeMonoid[X],
          NormedMultiplicativeSemigroup[X, S],
          NormedMultiplicativeIdentity[X, S]

/** The companion object for [[NormedMultiplicativeMonoid]]. */
object NormedMultiplicativeMonoid extends NormedMultiplicativeMonoid.Ops:

  trait Ops
    extends MultiplicativeMonoid.Ops,
            NormedMultiplicativeSemigroup.Ops,
            NormedMultiplicativeIdentity.Ops

  type Over[S] = [X] =>> NormedMultiplicativeMonoid[X, S]

  export com.alecdorrington.scalgebra.normed.NormedMultiplicativeMonoid

  /**
    * The [[NormedMultiplicativeMonoid]] instance describing the current algebra
    * system.
    */
  inline def normedMultiplicativeMonoid[X, S]
    (using ev: NormedMultiplicativeMonoid[X, S])
    : NormedMultiplicativeMonoid[X, S] = ev
