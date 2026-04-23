package com.alecdorrington.scalgebra
package normed

/** A normed version of [[DifferenceSemiring]]. */
trait NormedDifferenceSemiring[X, S]
  extends DifferenceSemiring[X],
          NormedSemiring[X, S],
          NormedDifferenceMonoid[X, S]

/** The companion object for [[NormedDifferenceSemiring]]. */
object NormedDifferenceSemiring extends NormedDifferenceSemiring.Ops:

  trait Ops
    extends DifferenceSemiring.Ops,
            NormedSemiring.Ops,
            NormedDifferenceMonoid.Ops

  type Over[S] = [X] =>> NormedDifferenceSemiring[X, S]

  export com.alecdorrington.scalgebra.normed.NormedDifferenceSemiring

  /**
    * The [[NormedDifferenceSemiring]] instance describing the current algebra
    * system.
    */
  inline def normedDifferenceSemiring[X, S]
    (using ev: NormedDifferenceSemiring[X, S])
    : NormedDifferenceSemiring[X, S] = ev
