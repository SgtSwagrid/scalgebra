package com.alecdorrington.scalgebra

import com.alecdorrington.scalgebra.builder.EuclideanMonoidBuilder
import com.alecdorrington.scalgebra.ops.EuclideanMonoidOps

/** For algebraic structures with multiplication and division. */
trait EuclideanMonoid[X] extends MultiplicativeMonoid[X]:

  /** Computes the quotient between two values [[x]] and [[y]], i.e. `x / y`. */
  def divide(x: X, y: X): X

/**
  * The companion object for [[EuclideanMonoid]]. Import as
  * ```scala
  * import com.alecdorrington.scalgebra.EuclideanMonoid.{*, given}
  * ```
  * to receive all necessary syntax for working with Euclidean monoids.
  */
object EuclideanMonoid extends EuclideanMonoidBuilder, EuclideanMonoidOps:

  export com.alecdorrington.scalgebra.EuclideanMonoid

  /** The [[EuclideanMonoid]] instance describing the current algebra system. */
  inline def euclideanMonoid[X : EuclideanMonoid as euclideanMonoid]
    : EuclideanMonoid[X] = euclideanMonoid
