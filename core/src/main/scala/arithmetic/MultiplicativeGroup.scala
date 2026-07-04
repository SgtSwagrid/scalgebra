package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Inversion: `x × x.reciprocal == x.reciprocal × x == one`, whenever the
  *     reciprocal is defined.
  */
trait MultiplicativeGroup[X]
  extends QuotientMonoid[X], MultiplicativeInverse[X]:

  extension (x: X)

    override def div(y: X): X = x * y.reciprocal

    /**
      * Computes [[x]] raised to the power of [[n]], for any integer [[n]].
      *
      * @throws ArithmeticException
      *   if `n < 0` and `x == zero`.
      */
    override def pow(n: Int): X =
      if n == Int.MinValue then x.reciprocal.pow(Int.MaxValue) * x.reciprocal
      else super.pow(if n >= 0 then x else x.reciprocal)(n.abs)
