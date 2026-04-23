package com.alecdorrington.scalgebra

/** For algebraic structures with an additive inverse. */
trait AdditiveInverse[X] extends Root[X]:

  /**
    * Computes the additive inverse (negative) of a value [[x]], i.e. `-x`.
    *
    * @note
    *   All implementations must be involutions, i.e. `negate(negate(x)) == x`.
    */
  def negate(x: X): X

  extension (x: X)

    /** Computes the additive inverse (negative) of this value. */
    inline def unary_- : X = negate(x)

/** The companion object for [[AdditiveInverse]]. */
object AdditiveInverse extends AdditiveInverse.Ops:

  trait Ops:

    /**
      * Computes the additive inverse (negative) of a value [[x]], i.e. `-x`.
      *
      * @note
      *   All implementations must be involutions, i.e.
      *   `negate(negate(x)) == x`.
      */
    inline def negate[X : AdditiveInverse as X](x: X): X = X.negate(x)

  export com.alecdorrington.scalgebra.AdditiveInverse

  /** The [[AdditiveInverse]] instance describing the current algebra system. */
  inline def additiveInverse[X : AdditiveInverse as additiveInverse]
    : AdditiveInverse[X] = additiveInverse
