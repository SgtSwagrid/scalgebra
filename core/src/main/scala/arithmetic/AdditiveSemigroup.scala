package com.alecdorrington.scalgebra
package arithmetic

import scala.annotation.tailrec

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Associativity: `(x + y) + z == x + (y + z)`.
  */
trait AdditiveSemigroup[X] extends AdditiveMagma[X]:

  extension (x: X)

    /**
      * Computes [[x]] multiplied by [[n]], for any strictly positive integer
      * [[n]].
      *
      * @throws IllegalArgumentException
      *   if `n ≤ 0`.
      */
    def scale(n: Int): X =
      require(
        n > 0,
        s"Non-positive multipliers (i.e. '$n') aren't defined for this algebra.",
      )
      @tailrec
      def recurse(x: X, n: Int, acc: X): X =
        if n == 0 then acc
        else if n % 2 == 0 then recurse(x + x, n / 2, acc)
        else recurse(x, n - 1, acc + x)
      recurse(x, n - 1, x)

    /** An alias for [[scale]], with the factor on the left. */
    inline infix def *: (n: Int): X = x.scale(n)

    /** An alias for [[scale]], with the factor on the right. */
    inline infix def :* (n: Int): X = x.scale(n)

  extension (xs: Iterable[X])

    /**
      * Computes the sum of all values in [[xs]], i.e. `xs₁ + xs₂ + …`, or else
      * [[None]] if [[xs]] is empty.
      */
    inline def sumOption: Option[X] = xs.reduceOption(_ + _)

    /**
      * Computes the sum of all values in [[xs]], i.e. `xs₁ + xs₂ + …`, or else
      * [[default]] if [[xs]] is empty.
      */
    inline def sumOrElse[Y >: X](default: Y): Y = xs
      .sumOption
      .getOrElse(default)

    /**
      * Computes the sum of [[x]] and all values in [[xs]], i.e.
      * `x + xs₁ + xs₂ + …`.
      */
    inline def sumFrom(x: X): X = xs.foldLeft(x)(_ + _)
