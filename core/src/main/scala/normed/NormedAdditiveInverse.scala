package com.alecdorrington.scalgebra
package normed

/** A normed version of [[AdditiveInverse]]. */
trait NormedAdditiveInverse[X, S] extends AdditiveInverse[X], Normed[X, S]

/** The companion object for [[NormedAdditiveInverse]]. */
object NormedAdditiveInverse extends NormedAdditiveInverse.Ops:

  trait Ops extends AdditiveInverse.Ops, Normed.Ops

  type Over[S] = [X] =>> NormedAdditiveInverse[X, S]

  export com.alecdorrington.scalgebra.normed.NormedAdditiveInverse

  /**
    * The [[NormedAdditiveInverse]] instance describing the current algebra
    * system.
    */
  inline def normedAdditiveInverse[X, S]
    (using ev: NormedAdditiveInverse[X, S])
    : NormedAdditiveInverse[X, S] = ev
