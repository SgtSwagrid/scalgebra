package com.alecdorrington.scalgebra
package normed

/** A normed version of [[MultiplicativeInverse]]. */
trait NormedMultiplicativeInverse[X, S]
  extends MultiplicativeInverse[X], Normed[X, S]

/** The companion object for [[NormedMultiplicativeInverse]]. */
object NormedMultiplicativeInverse extends NormedMultiplicativeInverse.Ops:

  trait Ops extends MultiplicativeInverse.Ops, Normed.Ops

  type Over[S] = [X] =>> NormedMultiplicativeInverse[X, S]

  export com.alecdorrington.scalgebra.normed.NormedMultiplicativeInverse

  /**
    * The [[NormedMultiplicativeInverse]] instance describing the current
    * algebra system.
    */
  inline def normedMultiplicativeInverse[X, S]
    (using ev: NormedMultiplicativeInverse[X, S])
    : NormedMultiplicativeInverse[X, S] = ev
