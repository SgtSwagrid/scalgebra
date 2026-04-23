package com.alecdorrington.scalgebra
package normed

/** A normed version of [[MultiplicativeGroup]]. */
trait NormedMultiplicativeGroup[X, S]
  extends MultiplicativeGroup[X],
          NormedEuclideanMonoid[X, S],
          NormedMultiplicativeInverse[X, S]

/** The companion object for [[NormedMultiplicativeGroup]]. */
object NormedMultiplicativeGroup extends NormedMultiplicativeGroup.Ops:

  trait Ops
    extends MultiplicativeGroup.Ops,
            NormedEuclideanMonoid.Ops,
            NormedMultiplicativeInverse.Ops

  type Over[S] = [X] =>> NormedMultiplicativeGroup[X, S]

  export com.alecdorrington.scalgebra.normed.NormedMultiplicativeGroup

  /**
    * The [[NormedMultiplicativeGroup]] instance describing the current algebra
    * system.
    */
  inline def normedMultiplicativeGroup[X, S]
    (using ev: NormedMultiplicativeGroup[X, S])
    : NormedMultiplicativeGroup[X, S] = ev
