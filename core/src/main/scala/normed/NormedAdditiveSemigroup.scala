package com.alecdorrington.scalgebra
package normed

/** A normed version of [[AdditiveSemigroup]]. */
trait NormedAdditiveSemigroup[X, S] extends AdditiveSemigroup[X], Normed[X, S]

/** The companion object for [[NormedAdditiveSemigroup]]. */
object NormedAdditiveSemigroup extends NormedAdditiveSemigroup.Ops:

  trait Ops extends AdditiveSemigroup.Ops, Normed.Ops

  type Over[S] = [X] =>> NormedAdditiveSemigroup[X, S]

  export com.alecdorrington.scalgebra.normed.NormedAdditiveSemigroup

  /**
    * The [[NormedAdditiveSemigroup]] instance describing the current algebra
    * system.
    */
  inline def normedAdditiveSemigroup[X, S]
    (using ev: NormedAdditiveSemigroup[X, S])
    : NormedAdditiveSemigroup[X, S] = ev
