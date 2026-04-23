package com.alecdorrington.scalgebra
package normed

/** A normed version of [[Semifield]]. */
trait NormedSemifield[X, S]
  extends Semifield[X], NormedSemiring[X, S], NormedMultiplicativeGroup[X, S]

/** The companion object for [[NormedSemifield]]. */
object NormedSemifield extends NormedSemifield.Ops:

  trait Ops
    extends Semifield.Ops, NormedSemiring.Ops, NormedMultiplicativeGroup.Ops

  type Over[S] = [X] =>> NormedSemifield[X, S]

  export com.alecdorrington.scalgebra.normed.NormedSemifield

  /** The [[NormedSemifield]] instance describing the current algebra system. */
  inline def normedSemifield[X, S]
    (using ev: NormedSemifield[X, S])
    : NormedSemifield[X, S] = ev
