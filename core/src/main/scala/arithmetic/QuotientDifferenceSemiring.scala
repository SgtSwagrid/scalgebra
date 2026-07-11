package com.alecdorrington.scalgebra
package arithmetic

import scala.annotation.tailrec

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Subtraction
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  */
trait QuotientDifferenceSemiring[X]
  extends QuotientSemiring[X], DifferenceSemiring[X]:

  extension (x: X)

    /**
      * Computes the [signed remainder](https://en.wikipedia.org/wiki/Modulo)
      * between a dividend [[x]] and a divisor [[y]].
      *
      * The sign of [[x]] only determines the sign of the result. The sign of
      * [[y]] is ignored.
      *
      * @throws ArithmeticException
      *   if `y == zero`.
      *
      * @note
      *   The result will always fall in the half-open interval `[0, |y|)` if
      *   `x ≥ 0`, or otherwise in `(-|y|, 0]` if `x < 0`.
      *
      * @see
      *   [[ordered.OrderedQuotientRing.floorMod floorMod]],
      *   [[ordered.OrderedQuotientRing.euclideanMod euclideanMod]].
      */
    def mod(y: X): X = x - ((x / y) * y)

    /** A version of [[mod]] which returns [[None]] when `y == zero`. */
    inline def modOption(y: X): Option[X] = Option.when(y.nonZero)(x % y)

    /**
      * Computes the [greatest common
      * divisor](https://en.wikipedia.org/wiki/Greatest_common_divisor) of [[x]]
      * and [[y]].
      */
    def gcd(y: X): X =
      @tailrec
      def recurse(x: X, y: X): X = if y.isZero then x else recurse(y, x % y)
      recurse(x, y)

    /**
      * Computes the [lowest common
      * multiple](https://en.wikipedia.org/wiki/Least_common_multiple) of [[x]]
      * and [[y]].
      */
    def lcm(y: X): X =
      val g = x.gcd(y)
      if g.isZero then g else (x / g) * y

    /** An alias for [[mod]]. */
    inline infix def % (y: X): X = x.mod(y)
