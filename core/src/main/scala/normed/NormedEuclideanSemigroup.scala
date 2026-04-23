package com.alecdorrington.scalgebra
package normed

/** A normed version of [[EuclideanSemigroup]]. */
trait NormedEuclideanSemigroup[X, S]
  extends EuclideanSemigroup[X], NormedMultiplicativeSemigroup[X, S]

/** The companion object for [[NormedEuclideanSemigroup]]. */
object NormedEuclideanSemigroup extends NormedEuclideanSemigroup.Ops:

  trait Ops extends EuclideanSemigroup.Ops, NormedMultiplicativeSemigroup.Ops

  type Over[S] = [X] =>> NormedEuclideanSemigroup[X, S]

  export com.alecdorrington.scalgebra.normed.NormedEuclideanSemigroup

  /**
    * The [[NormedEuclideanSemigroup]] instance describing the current algebra
    * system.
    */
  inline def normedEuclideanSemigroup[X, S]
    (using ev: NormedEuclideanSemigroup[X, S])
    : NormedEuclideanSemigroup[X, S] = ev
