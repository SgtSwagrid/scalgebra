package com.alecdorrington.scalgebra
package normed

/** A normed version of [[Field]]. */
trait NormedField[X, S]
  extends Field[X], NormedEuclideanRing[X, S], NormedDifferenceSemifield[X, S]

/** The companion object for [[NormedField]]. */
object NormedField extends NormedField.Ops:

  trait Ops
    extends Field.Ops, NormedEuclideanRing.Ops, NormedDifferenceSemifield.Ops

  type Over[S] = [X] =>> NormedField[X, S]

  export com.alecdorrington.scalgebra.normed.NormedField

  /** The [[NormedField]] instance describing the current algebra system. */
  inline def normedField[X, S](using ev: NormedField[X, S]): NormedField[X, S] =
    ev
