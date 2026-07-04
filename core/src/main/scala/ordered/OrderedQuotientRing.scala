package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.QuotientRing

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  *   - Total order
  */
trait OrderedQuotientRing[X]
  extends QuotientRing[X], OrderedRing[X], OrderedQuotientDifferenceSemiring[X]:

  extension (x: X)

    /**
      * Computes the [floored remainder](https://en.wikipedia.org/wiki/Modulo)
      * between a dividend [[x]] and a divisor [[y]].
      *
      * The sign of [[y]] determines the sign of the result. The sign of [[x]]
      * is ignored.
      *
      * @throws ArithmeticException
      *   if `y == zero`.
      *
      * @note
      *   The result will always fall in the half-open interval `[0, y)` if
      *   `y > 0`, or otherwise in `(y, 0]` if `y < 0`.
      *
      * @see
      *   [[mod]], [[euclideanMod]].
      */
    def floorMod(y: X): X =
      val r = x % y
      if r.isZero || r.sign == y.sign then r else r + y

    /**
      * Computes the floored quotient between a dividend [[x]] and a divisor
      * [[y]].
      *
      * @throws ArithmeticException
      *   if `y == zero`.
      *
      * @note
      *   For imprecise (e.g. integer) arithmetic, the result is rounded towards
      *   negative infinity.
      *
      * @see
      *   [[div]], [[euclideanDiv]].
      */
    def floorDiv(y: X): X = (x - x.floorMod(y)) / y

    /**
      * Computes the [Euclidean remainder](https://en.wikipedia.org/wiki/Modulo)
      * between a dividend [[x]] and a divisor [[y]].
      *
      * The signs of [[x]] and [[y]] are both ignored.
      *
      * @throws ArithmeticException
      *   if `y == zero`.
      *
      * @note
      *   The result will always be non-negative, and fall in the half-open
      *   interval `[0, |y|)`.
      *
      * @see
      *   [[mod]], [[floorMod]].
      */
    def euclideanMod(y: X): X =
      val r = x % y
      if r.isNegative then r + y.abs else r

    /**
      * Computes the Euclidean quotient between a dividend [[x]] and a divisor
      * [[y]].
      *
      * @throws ArithmeticException
      *   if `y == zero`.
      *
      * @note
      *   For imprecise (e.g. integer) arithmetic, the result is rounded towards
      *   negative infinity if `y > 0`, or otherwise towards positive infinity
      *   if `y < 0`.
      *
      * @see
      *   [[div]], [[floorDiv]].
      */
    def euclideanDiv(y: X): X = (x - x.euclideanMod(y)) / y
