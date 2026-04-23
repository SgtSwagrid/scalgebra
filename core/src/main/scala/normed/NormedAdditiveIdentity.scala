package com.alecdorrington.scalgebra
package normed

/** A normed version of [[AdditiveIdentity]]. */
trait NormedAdditiveIdentity[X, S] extends AdditiveIdentity[X], Normed[X, S]

/** The companion object for [[NormedAdditiveIdentity]]. */
object NormedAdditiveIdentity extends NormedAdditiveIdentity.Ops:

  trait Ops extends AdditiveIdentity.Ops, Normed.Ops

  type Over[S] = [X] =>> NormedAdditiveIdentity[X, S]

  export com.alecdorrington.scalgebra.normed.NormedAdditiveIdentity

  /**
    * The [[NormedAdditiveIdentity]] instance describing the current algebra
    * system.
    */
  inline def normedAdditiveIdentity[X, S]
    (using ev: NormedAdditiveIdentity[X, S])
    : NormedAdditiveIdentity[X, S] = ev
