package com.alecdorrington.scalgebra
package normed

/** A normed version of [[DifferenceSemifield]]. */
trait NormedDifferenceSemifield[X, S]
  extends DifferenceSemifield[X],
          NormedDifferenceSemiring[X, S],
          NormedSemifield[X, S]

/** The companion object for [[NormedDifferenceSemifield]]. */
object NormedDifferenceSemifield extends NormedDifferenceSemifield.Ops:

  trait Ops
    extends DifferenceSemifield.Ops,
            NormedDifferenceSemiring.Ops,
            NormedSemifield.Ops

  type Over[S] = [X] =>> NormedDifferenceSemifield[X, S]

  export com.alecdorrington.scalgebra.normed.NormedDifferenceSemifield

  /**
    * The [[NormedDifferenceSemifield]] instance describing the current algebra
    * system.
    */
  inline def normedDifferenceSemifield[X, S]
    (using ev: NormedDifferenceSemifield[X, S])
    : NormedDifferenceSemifield[X, S] = ev
