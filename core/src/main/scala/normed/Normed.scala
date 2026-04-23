package com.alecdorrington.scalgebra
package normed

import scala.annotation.targetName

/** For algebraic structures with a norm. */
trait Normed[X, S] extends Root[X]:

  /** Computes the length (norm) of [[x]]. */
  protected def norm(x: X): S

  extension (x: X)

    /** Computes the length (norm) of [[x]]. */
    inline def length: S = Normed.this.norm(x)

/** The companion object for [[Normed]]. */
object Normed extends Normed.Ops:

  trait Ops:

    inline def length[X, S](x: X)(using ev: Normed[X, S]): S = ev.length(x)

  type Over[S] = [X] =>> Normed[X, S]

  export com.alecdorrington.scalgebra.normed.Normed

  /** The [[Normed]] instance describing the current algebra system. */
  inline def normed[X, S](using ev: Normed[X, S]): Normed[X, S] = ev
