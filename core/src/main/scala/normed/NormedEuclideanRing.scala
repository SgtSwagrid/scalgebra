package com.alecdorrington.scalgebra
package normed

/** A normed version of [[EuclideanRing]]. */
trait NormedEuclideanRing[X, S]
  extends EuclideanRing[X], NormedRing[X, S], NormedEuclideanMonoid[X, S]

/** The companion object for [[NormedEuclideanRing]]. */
object NormedEuclideanRing extends NormedEuclideanRing.Ops:

  trait Ops extends EuclideanRing.Ops, NormedRing.Ops, NormedEuclideanMonoid.Ops

  type Over[S] = [X] =>> NormedEuclideanRing[X, S]

  export com.alecdorrington.scalgebra.normed.NormedEuclideanRing

  /**
    * The [[NormedEuclideanRing]] instance describing the current algebra
    * system.
    */
  inline def normedEuclideanRing[X, S]
    (using ev: NormedEuclideanRing[X, S])
    : NormedEuclideanRing[X, S] = ev
