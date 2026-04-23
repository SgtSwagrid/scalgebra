package com.alecdorrington.scalgebra

/** For algebraic structures with a subtraction operator. */
trait Difference[X] extends Root[X]:

  /** Computes the difference between two values [[x]] and [[y]], i.e. `x - y`. */
  def subtract(x: X, y: X): X

  extension (x: X)

    /**
      * Computes the difference between two values [[x]] and [[y]], i.e.
      * `x - y`.
      */
    inline infix def - (y: X): X = subtract(x, y)

/** The companion object for [[Difference]]. */
object Difference extends Difference.Ops:

  trait Ops:

    /**
      * Computes the difference between two values [[x]] and [[y]], i.e.
      * `x - y`.
      */
    inline def subtract[X : Difference as X](x: X, y: X): X = X.subtract(x, y)

  export com.alecdorrington.scalgebra.Difference

  /** The [[Difference]] instance describing the current algebra system. */
  inline def difference[X : Difference as difference]: Difference[X] =
    difference
