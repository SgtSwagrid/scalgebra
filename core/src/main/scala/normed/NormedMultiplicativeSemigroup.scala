package com.alecdorrington.scalgebra
package normed

/** A normed version of [[MultiplicativeSemigroup]]. */
trait NormedMultiplicativeSemigroup[X, S]
  extends MultiplicativeSemigroup[X], Normed[X, S]

/** The companion object for [[NormedMultiplicativeSemigroup]]. */
object NormedMultiplicativeSemigroup extends NormedMultiplicativeSemigroup.Ops:

  trait Ops extends MultiplicativeSemigroup.Ops, Normed.Ops

  type Over[S] = [X] =>> NormedMultiplicativeSemigroup[X, S]

  export com.alecdorrington.scalgebra.normed.NormedMultiplicativeSemigroup

  /**
    * The [[NormedMultiplicativeSemigroup]] instance describing the current
    * algebra system.
    */
  inline def normedMultiplicativeSemigroup[X, S]
    (using ev: NormedMultiplicativeSemigroup[X, S])
    : NormedMultiplicativeSemigroup[X, S] = ev
