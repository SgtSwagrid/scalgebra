package com.alecdorrington.scalgebra
package normed

/** A normed version of [[DifferenceSemigroup]]. */
trait NormedDifferenceSemigroup[X, S]
  extends DifferenceSemigroup[X],
          NormedAdditiveSemigroup[X, S],
          NormedDifference[X, S]

/** The companion object for [[NormedDifferenceSemigroup]]. */
object NormedDifferenceSemigroup extends NormedDifferenceSemigroup.Ops:

  trait Ops extends DifferenceSemigroup.Ops, NormedAdditiveSemigroup.Ops, NormedDifference.Ops

  type Over[S] = [X] =>> NormedDifferenceSemigroup[X, S]

  export com.alecdorrington.scalgebra.normed.NormedDifferenceSemigroup

  /**
    * The [[NormedDifferenceSemigroup]] instance describing the current algebra
    * system.
    */
  inline def normedDifferenceSemigroup[X, S]
    (using ev: NormedDifferenceSemigroup[X, S])
    : NormedDifferenceSemigroup[X, S] = ev
