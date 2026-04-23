package com.alecdorrington.scalgebra
package normed

/** A normed version of [[Ring]]. */
trait NormedRing[X, S]
  extends Ring[X], NormedPseudoring[X, S], NormedDifferenceSemiring[X, S]

/** The companion object for [[NormedRing]]. */
object NormedRing extends NormedRing.Ops:

  trait Ops extends Ring.Ops, NormedPseudoring.Ops, NormedDifferenceSemiring.Ops

  type Over[S] = [X] =>> NormedRing[X, S]

  export com.alecdorrington.scalgebra.normed.NormedRing

  /** The [[NormedRing]] instance describing the current algebra system. */
  inline def normedRing[X, S](using ev: NormedRing[X, S]): NormedRing[X, S] = ev
