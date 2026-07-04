package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Identity: `x + zero == zero + x == x`.
  */
trait AdditiveMonoid[X] extends AdditiveSemigroup[X], AdditiveIdentity[X]:

  extension (x: X)

    /**
      * Computes [[x]] multiplied by [[n]], for any non-negative integer [[n]].
      *
      * @throws IllegalArgumentException
      *   if `n < 0`.
      */
    override def scale(n: Int): X =
      require(
        n >= 0,
        s"Negative multipliers (i.e. '$n') aren't defined for this algebra.",
      )
      if n == 0 then zero else super.scale(x)(n)

  extension (xs: Iterable[X])

    /**
      * Computes the sum of all values in [[xs]], i.e. `xs₁ + xs₂ + …`, or else
      * [[zero]] if [[xs]] is empty.
      */
    inline def sumOrZero: X = xs.sumOrElse(zero)
