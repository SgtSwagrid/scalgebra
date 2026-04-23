package com.alecdorrington.scalgebra
package normed

/** A normed version of [[EuclideanMonoid]]. */
trait NormedEuclideanMonoid[X, S]
  extends EuclideanMonoid[X],
          NormedEuclideanSemigroup[X, S],
          NormedMultiplicativeMonoid[X, S]

/** The companion object for [[NormedEuclideanMonoid]]. */
object NormedEuclideanMonoid extends NormedEuclideanMonoid.Ops:

  trait Ops
    extends EuclideanMonoid.Ops,
            NormedEuclideanSemigroup.Ops,
            NormedMultiplicativeMonoid.Ops

  type Over[S] = [X] =>> NormedEuclideanMonoid[X, S]

  export com.alecdorrington.scalgebra.normed.NormedEuclideanMonoid

  /**
    * The [[NormedEuclideanMonoid]] instance describing the current algebra
    * system.
    */
  inline def normedEuclideanMonoid[X, S]
    (using ev: NormedEuclideanMonoid[X, S])
    : NormedEuclideanMonoid[X, S] = ev
