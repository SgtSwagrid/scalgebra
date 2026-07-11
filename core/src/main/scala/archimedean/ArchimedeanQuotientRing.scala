package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedQuotientRing

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanQuotientRing[X]
  extends ArchimedeanRing[X],
          ArchimedeanQuotientDifferenceSemiring[X],
          OrderedQuotientRing[X]:

  extension (x: X)

    /**
      * Computes the [signed remainder](https://en.wikipedia.org/wiki/Modulo)
      * between a dividend [[x]] and a divisor [[y]], relative to the nearest
      * integer quotient rounded towards zero.
      *
      * Unlike [[mod]], which inherits its rounding behaviour from [[div]] (and
      * is therefore always [[zero]] when division is exact), the quotient here
      * is always rounded to an integer value first. The two coincide when
      * [[div]] itself produces integer values.
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
      *   [[floorRemainder]], [[euclideanRemainder]].
      */
    def remainder(y: X): X = x - ((x / y).truncate * y)

    /**
      * Computes the [floored remainder](https://en.wikipedia.org/wiki/Modulo)
      * between a dividend [[x]] and a divisor [[y]], relative to the nearest
      * integer quotient rounded towards negative infinity.
      *
      * Unlike [[floorMod]], which inherits its rounding behaviour from [[div]]
      * (and is therefore always [[zero]] when division is exact), the quotient
      * here is always rounded to an integer value first. The two coincide when
      * [[div]] itself produces integer values.
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
      *   [[remainder]], [[euclideanRemainder]].
      */
    def floorRemainder(y: X): X =
      val r = x.remainder(y)
      if r.isZero || r.sign == y.sign then r else r + y

    /**
      * Computes the [Euclidean remainder](https://en.wikipedia.org/wiki/Modulo)
      * between a dividend [[x]] and a divisor [[y]], relative to the nearest
      * integer quotient rounded away from the remainder.
      *
      * Unlike [[euclideanMod]], which inherits its rounding behaviour from
      * [[div]] (and is therefore always [[zero]] when division is exact), the
      * quotient here is always rounded to an integer value first. The two
      * coincide when [[div]] itself produces integer values.
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
      *   [[remainder]], [[floorRemainder]].
      */
    def euclideanRemainder(y: X): X =
      val r = x.remainder(y)
      if r.isNegative then r + y.abs else r
