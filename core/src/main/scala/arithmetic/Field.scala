package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  */
trait Field[X] extends QuotientRing[X], DifferenceSemifield[X]:

  extension (x: X)

    /**
      * Computes the remainder upon dividing [[x]] by [[y]].
      *
      * @note
      *   In a field, division is exact, so the remainder is always [[zero]].
      */
    override def mod(y: X): X = zero

    /**
      * Computes the [greatest common
      * divisor](https://en.wikipedia.org/wiki/Greatest_common_divisor) of [[x]]
      * and [[y]].
      *
      * @note
      *   In a field, every non-zero value divides every other, so the result is
      *   canonically [[one]], unless both operands are [[zero]].
      */
    override def gcd(y: X): X = if x.isZero && y.isZero then zero else one

    /**
      * Computes the [lowest common
      * multiple](https://en.wikipedia.org/wiki/Least_common_multiple) of [[x]]
      * and [[y]].
      *
      * @note
      *   In a field, every non-zero value is a multiple of every other, so the
      *   result is canonically [[one]], unless either operand is [[zero]].
      */
    override def lcm(y: X): X = if x.isZero || y.isZero then zero else one
