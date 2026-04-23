package com.alecdorrington.scalgebra

/** For algebraic structures with addition, subtraction, and an identity. */
trait DifferenceMonoid[X] extends DifferenceSemigroup[X], AdditiveMonoid[X]

/** The companion object for [[DifferenceMonoid]]. */
object DifferenceMonoid extends DifferenceMonoid.Ops:

  trait Ops extends DifferenceSemigroup.Ops, AdditiveMonoid.Ops

  export com.alecdorrington.scalgebra.DifferenceMonoid

  /** The [[DifferenceMonoid]] instance describing the current algebra system. */
  inline def differenceMonoid[X : DifferenceMonoid as differenceMonoid]
    : DifferenceMonoid[X] = differenceMonoid
