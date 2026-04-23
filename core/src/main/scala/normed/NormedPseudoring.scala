package com.alecdorrington.scalgebra
package normed

/** A normed version of [[Pseudoring]]. */
trait NormedPseudoring[X, S]
  extends Pseudoring[X],
          NormedAdditiveGroup[X, S],
          NormedMultiplicativeSemigroup[X, S]

/** The companion object for [[NormedPseudoring]]. */
object NormedPseudoring extends NormedPseudoring.Ops:

  trait Ops
    extends Pseudoring.Ops,
            NormedAdditiveGroup.Ops,
            NormedMultiplicativeSemigroup.Ops

  type Over[S] = [X] =>> NormedPseudoring[X, S]

  export com.alecdorrington.scalgebra.normed.NormedPseudoring

  /** The [[NormedPseudoring]] instance describing the current algebra system. */
  inline def normedPseudoring[X, S]
    (using ev: NormedPseudoring[X, S])
    : NormedPseudoring[X, S] = ev
