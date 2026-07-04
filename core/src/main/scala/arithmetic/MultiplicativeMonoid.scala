package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Identity: `x × one == one × x == x`.
  */
trait MultiplicativeMonoid[X]
  extends MultiplicativeSemigroup[X], MultiplicativeIdentity[X]:

  extension (x: X)

    /**
      * Computes [[x]] raised to the power of [[n]], for any non-negative
      * integer [[n]].
      *
      * @throws IllegalArgumentException
      *   if `n < 0`.
      */
    override def pow(n: Int): X =
      require(
        n >= 0,
        s"Negative exponents (i.e. '$n') aren't defined for this algebra.",
      )
      if n == 0 then one else super.pow(x)(n)

  extension (xs: Iterable[X])

    /**
      * Computes the product of all values in [[xs]], i.e. `xs₁ × xs₂ × …`, or
      * else [[one]] if [[xs]] is empty.
      */
    inline def productOrOne: X = xs.productOrElse(one)
