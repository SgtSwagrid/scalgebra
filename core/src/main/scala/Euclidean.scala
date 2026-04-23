package com.alecdorrington.scalgebra

/** For algebraic structures with a division operator. */
trait Euclidean[X] extends Root[X]:

  /** Computes the quotient between two values [[x]] and [[y]], i.e. `x / y`. */
  def divide(x: X, y: X): X

  extension (x: X)

    /** Computes the quotient between two values [[x]] and [[y]], i.e. `x / y`. */
    inline infix def / (y: X): X = divide(x, y)

/** The companion object for [[Euclidean]]. */
object Euclidean extends Euclidean.Ops:

  trait Ops:

    /** Computes the quotient between two values [[x]] and [[y]], i.e. `x / y`. */
    inline def divide[X : Euclidean as X](x: X, y: X): X = X.divide(x, y)

  export com.alecdorrington.scalgebra.Euclidean

  /** The [[Euclidean]] instance describing the current algebra system. */
  inline def euclidean[X : Euclidean as euclidean]: Euclidean[X] = euclidean
