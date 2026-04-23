package com.alecdorrington.scalgebra

/** For algebraic structures with addition, negation, and multiplication. */
trait Pseudoring[X] extends AdditiveGroup[X], MultiplicativeSemigroup[X]

/** The companion object for [[Pseudoring]]. */
object Pseudoring extends Pseudoring.Ops:

  trait Ops extends AdditiveGroup.Ops, MultiplicativeSemigroup.Ops

  export com.alecdorrington.scalgebra.Pseudoring

  /** The [[Pseudoring]] instance describing the current algebra system. */
  inline def pseudoring[X : Pseudoring as pseudoring]: Pseudoring[X] =
    pseudoring
