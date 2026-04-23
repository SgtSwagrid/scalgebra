package com.alecdorrington.scalgebra
package normed

/** A normed version of [[AdditiveGroup]]. */
trait NormedAdditiveGroup[X, S]
  extends AdditiveGroup[X],
          NormedDifferenceMonoid[X, S],
          NormedAdditiveInverse[X, S]

/** The companion object for [[NormedAdditiveGroup]]. */
object NormedAdditiveGroup extends NormedAdditiveGroup.Ops:

  trait Ops
    extends AdditiveGroup.Ops,
            NormedDifferenceMonoid.Ops,
            NormedAdditiveInverse.Ops

  type Over[S] = [X] =>> NormedAdditiveGroup[X, S]

  export com.alecdorrington.scalgebra.normed.NormedAdditiveGroup

  /**
    * The [[NormedAdditiveGroup]] instance describing the current algebra
    * system.
    */
  inline def normedAdditiveGroup[X, S]
    (using ev: NormedAdditiveGroup[X, S])
    : NormedAdditiveGroup[X, S] = ev
