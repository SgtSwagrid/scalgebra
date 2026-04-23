package com.alecdorrington.scalgebra
package normed

/** A normed version of [[Difference]]. */
trait NormedDifference[X, S] extends Difference[X], Normed[X, S]:

  /** Computes the distance between [[x]] and [[y]], i.e. `‖x − y‖`. */
  def distance(x: X, y: X): S = length(subtract(x, y))

  extension (x: X)

    /** Computes the distance between [[x]] and [[y]], i.e. `‖x − y‖`. */
    def distanceTo(y: X): S = distance(x, y)

/** The companion object for [[NormedDifference]]. */
object NormedDifference extends NormedDifference.Ops:

  trait Ops extends Difference.Ops, Normed.Ops:

    /** Computes the distance between [[x]] and [[y]], i.e. `‖x − y‖`. */
    inline def distance[X, S](x: X, y: X)(using ev: NormedDifference[X, S]): S =
      ev.distance(x, y)

  type Over[S] = [X] =>> NormedDifference[X, S]

  export com.alecdorrington.scalgebra.normed.NormedDifference

  /** The [[NormedDifference]] instance describing the current algebra system. */
  inline def normedDifference[X, S]
    (using ev: NormedDifference[X, S])
    : NormedDifference[X, S] = ev
