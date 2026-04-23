package com.alecdorrington.scalgebra

/** For algebraic structures with multiplication and division. */
trait EuclideanSemigroup[X] extends MultiplicativeSemigroup[X], Euclidean[X]

/** The companion object for [[EuclideanSemigroup]]. */
object EuclideanSemigroup extends EuclideanSemigroup.Ops:

  trait Ops extends MultiplicativeSemigroup.Ops, Euclidean.Ops

  export com.alecdorrington.scalgebra.EuclideanSemigroup

  /** The [[EuclideanSemigroup]] instance describing the current algebra system. */
  inline def euclideanSemigroup[X : EuclideanSemigroup as euclideanSemigroup]
    : EuclideanSemigroup[X] = euclideanSemigroup
