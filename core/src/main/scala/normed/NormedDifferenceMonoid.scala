package com.alecdorrington.scalgebra
package normed

/** A normed version of [[DifferenceMonoid]]. */
trait NormedDifferenceMonoid[X, S]
  extends DifferenceMonoid[X],
          NormedDifferenceSemigroup[X, S],
          NormedAdditiveMonoid[X, S]

/** The companion object for [[NormedDifferenceMonoid]]. */
object NormedDifferenceMonoid extends NormedDifferenceMonoid.Ops:

  trait Ops
    extends DifferenceMonoid.Ops,
            NormedDifferenceSemigroup.Ops,
            NormedAdditiveMonoid.Ops

  type Over[S] = [X] =>> NormedDifferenceMonoid[X, S]

  export com.alecdorrington.scalgebra.normed.NormedDifferenceMonoid

  /**
    * The [[NormedDifferenceMonoid]] instance describing the current algebra
    * system.
    */
  inline def normedDifferenceMonoid[X, S]
    (using ev: NormedDifferenceMonoid[X, S])
    : NormedDifferenceMonoid[X, S] = ev
