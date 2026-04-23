package com.alecdorrington.scalgebra

/** For algebraic structures with multiplication, division, and an identity. */
trait EuclideanMonoid[X] extends EuclideanSemigroup[X], MultiplicativeMonoid[X]

/** The companion object for [[EuclideanMonoid]]. */
object EuclideanMonoid extends EuclideanMonoid.Ops:

  trait Ops extends EuclideanSemigroup.Ops, MultiplicativeMonoid.Ops

  export com.alecdorrington.scalgebra.EuclideanMonoid

  /** The [[EuclideanMonoid]] instance describing the current algebra system. */
  inline def euclideanMonoid[X : EuclideanMonoid as euclideanMonoid]
    : EuclideanMonoid[X] = euclideanMonoid
