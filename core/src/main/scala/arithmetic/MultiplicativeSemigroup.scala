package com.alecdorrington.scalgebra
package arithmetic

import scala.annotation.tailrec

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Associativity: `(x × y) × z == x × (y × z)`.
  */
trait MultiplicativeSemigroup[X] extends MultiplicativeMagma[X]:

  extension (x: X)

    /**
      * Computes [[x]] raised to the power of [[n]], for any strictly positive
      * integer [[n]].
      *
      * @throws IllegalArgumentException
      *   if `n ≤ 0`.
      */
    def pow(n: Int): X =
      require(
        n > 0,
        s"Non-positive exponents (i.e. '$n') aren't defined for this algebra.",
      )
      @tailrec
      def recurse(x: X, n: Int, acc: X): X =
        if n == 0 then acc
        else if n % 2 == 0 then recurse(x * x, n / 2, acc)
        else recurse(x, n - 1, acc * x)
      recurse(x, n - 1, x)

    /** An alias for [[pow]]. */
    inline infix def ** (n: Int): X = x.pow(n)

  extension (xs: Iterable[X])

    /**
      * Computes the product of all values in [[xs]], i.e. `xs₁ × xs₂ × …`, or
      * else [[None]] if [[xs]] is empty.
      */
    inline def productOption: Option[X] = xs.reduceOption(_ * _)

    /**
      * Computes the product of all values in [[xs]], i.e. `xs₁ × xs₂ × …`, or
      * else [[default]] if [[xs]] is empty.
      */
    inline def productOrElse[Y >: X](default: Y): Y = xs
      .productOption
      .getOrElse(default)

    /**
      * Computes the product of [[x]] and all values in [[xs]], i.e.
      * `x × xs₁ × xs₂ × …`.
      */
    inline def productFrom(x: X): X = xs.foldLeft(x)(_ * _)
