package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Division
  */
trait Quotient[X] extends Algebra[X]:

  extension (x: X)

    /**
      * Computes the quotient between a dividend [[x]] and a divisor [[y]], i.e.
      * `x / y`.
      *
      * @throws ArithmeticException
      *   if `y == zero`.
      *
      * @note
      *   For imprecise (e.g. integer) arithmetic, the result is rounded towards
      *   zero.
      *
      * @see
      *   [[ordered.OrderedQuotientRing.floorDiv floorDiv]],
      *   [[ordered.OrderedQuotientRing.euclideanDiv euclideanDiv]].
      */
    def div(y: X): X

    /** An alias for [[div]]. */
    inline infix def / (y: X): X = x.div(y)
