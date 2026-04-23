package com.alecdorrington.scalgebra
package normed

/** A normed version of [[Semiring]]. */
trait NormedSemiring[X, S]
  extends Semiring[X],
          NormedAdditiveMonoid[X, S],
          NormedMultiplicativeMonoid[X, S]

/** The companion object for [[NormedSemiring]]. */
object NormedSemiring extends NormedSemiring.Ops:

  trait Ops
    extends Semiring.Ops,
            NormedAdditiveMonoid.Ops,
            NormedMultiplicativeMonoid.Ops

  type Over[S] = [X] =>> NormedSemiring[X, S]

  export com.alecdorrington.scalgebra.normed.NormedSemiring

  /** The [[NormedSemiring]] instance describing the current algebra system. */
  inline def normedSemiring[X, S]
    (using ev: NormedSemiring[X, S])
    : NormedSemiring[X, S] = ev
