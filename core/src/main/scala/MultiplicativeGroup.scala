package com.alecdorrington.scalgebra

/** For algebraic structures with multiplication and reciprocation. */
trait MultiplicativeGroup[X]
  extends EuclideanMonoid[X], MultiplicativeInverse[X]:

  override inline def divide(x: X, y: X): X = multiply(x, reciprocate(y))

  /** Computes [[x]] raised to the power [[n]], for any integer [[n]]. */
  override def pow(x: X, n: Int): X =
    super.pow(if n >= 0 then x else reciprocate(x), n.abs)

/** The companion object for [[MultiplicativeGroup]]. */
object MultiplicativeGroup extends MultiplicativeGroup.Ops:

  trait Ops extends EuclideanMonoid.Ops, MultiplicativeInverse.Ops:

    /** Computes the quotient between two values [[x]] and [[y]], i.e. `x / y`. */
    inline def divide[X : MultiplicativeGroup as X](x: X, y: X): X =
      X.divide(x, y)

    /** Computes [[x]] raised to the power [[n]], for any integer [[n]]. */
    inline def pow[X : MultiplicativeGroup as X](x: X, n: Int): X = X.pow(x, n)

  export com.alecdorrington.scalgebra.MultiplicativeGroup

  /**
    * The [[MultiplicativeGroup]] instance describing the current algebra
    * system.
    */
  inline def multiplicativeGroup[X : MultiplicativeGroup as multiplicativeGroup]
    : MultiplicativeGroup[X] = multiplicativeGroup
