package com.alecdorrington.scalgebra

/** For algebraic structures with addition, subtraction, and multiplication. */
trait DifferenceSemiring[X] extends Semiring[X], DifferenceMonoid[X]

/** The companion object for [[DifferenceSemiring]]. */
object DifferenceSemiring extends DifferenceSemiring.Ops:

  trait Ops extends Semiring.Ops, DifferenceMonoid.Ops

  export com.alecdorrington.scalgebra.DifferenceSemiring

  /** The [[DifferenceSemiring]] instance describing the current algebra system. */
  inline def differenceSemiring[X : DifferenceSemiring as differenceSemiring]
    : DifferenceSemiring[X] = differenceSemiring
