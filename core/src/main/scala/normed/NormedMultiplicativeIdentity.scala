package com.alecdorrington.scalgebra
package normed

/** A normed version of [[MultiplicativeIdentity]]. */
trait NormedMultiplicativeIdentity[X, S]
  extends MultiplicativeIdentity[X], Normed[X, S]

/** The companion object for [[NormedMultiplicativeIdentity]]. */
object NormedMultiplicativeIdentity extends NormedMultiplicativeIdentity.Ops:

  trait Ops extends MultiplicativeIdentity.Ops, Normed.Ops

  type Over[S] = [X] =>> NormedMultiplicativeIdentity[X, S]

  export com.alecdorrington.scalgebra.normed.NormedMultiplicativeIdentity

  /**
    * The [[NormedMultiplicativeIdentity]] instance describing the current
    * algebra system.
    */
  inline def normedMultiplicativeIdentity[X, S]
    (using ev: NormedMultiplicativeIdentity[X, S])
    : NormedMultiplicativeIdentity[X, S] = ev
