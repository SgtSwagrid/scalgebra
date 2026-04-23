package com.alecdorrington.scalgebra
package normed

/** A normed version of [[Euclidean]]. */
trait NormedEuclidean[X, S] extends Euclidean[X], Normed[X, S]

/** The companion object for [[NormedEuclidean]]. */
object NormedEuclidean extends NormedEuclidean.Ops:

  trait Ops extends Euclidean.Ops, Normed.Ops

  type Over[S] = [X] =>> NormedEuclidean[X, S]

  export com.alecdorrington.scalgebra.normed.NormedEuclidean

  /** The [[NormedEuclidean]] instance describing the current algebra system. */
  inline def normedEuclidean[X, S]
    (using ev: NormedEuclidean[X, S])
    : NormedEuclidean[X, S] = ev
