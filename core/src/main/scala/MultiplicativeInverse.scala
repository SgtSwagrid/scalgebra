package com.alecdorrington.scalgebra

/** For algebraic structures with a multiplicative inverse. */
trait MultiplicativeInverse[X] extends Root[X]:

  /**
    * Computes the multiplicative inverse (reciprocal) of a value [[x]], i.e.
    * `1 / x`.
    *
    * @note
    *   All implementations must be involutions, i.e.
    *   `reciprocate(reciprocate(x)) == x`.
    */
  def reciprocate(x: X): X

  extension (x: X)

    /** Computes the multiplicative inverse (reciprocal) of this value. */
    inline def reciprocal: X = reciprocate(x)

/** The companion object for [[MultiplicativeInverse]]. */
object MultiplicativeInverse extends MultiplicativeInverse.Ops:

  trait Ops:

    /**
      * Computes the multiplicative inverse (reciprocal) of a value [[x]], i.e.
      * `1 / x`.
      *
      * @note
      *   All implementations must be involutions, i.e.
      *   `reciprocate(reciprocate(x)) == x`.
      */
    inline def reciprocate[X : MultiplicativeInverse as X](x: X): X = X
      .reciprocate(x)

  export com.alecdorrington.scalgebra.MultiplicativeInverse

  /**
    * The [[MultiplicativeInverse]] instance describing the current algebra
    * system.
    */
  inline def multiplicativeInverse[
    X : MultiplicativeInverse as multiplicativeInverse,
  ]: MultiplicativeInverse[X] = multiplicativeInverse
