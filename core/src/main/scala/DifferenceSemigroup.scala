package com.alecdorrington.scalgebra

/** For algebraic structures with addition and subtraction. */
trait DifferenceSemigroup[X] extends AdditiveSemigroup[X], Difference[X]

/** The companion object for [[DifferenceSemigroup]]. */
object DifferenceSemigroup extends DifferenceSemigroup.Ops:

  trait Ops extends AdditiveSemigroup.Ops, Difference.Ops

  export com.alecdorrington.scalgebra.DifferenceSemigroup

  /**
    * The [[DifferenceSemigroup]] instance describing the current algebra
    * system.
    */
  inline def differenceSemigroup[X : DifferenceSemigroup as differenceSemigroup]
    : DifferenceSemigroup[X] = differenceSemigroup
