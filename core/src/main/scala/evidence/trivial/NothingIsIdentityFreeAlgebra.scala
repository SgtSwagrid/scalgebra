package com.alecdorrington.scalgebra
package evidence
package trivial

import com.alecdorrington.scalgebra.ordered.{
  OrderedAdditiveInverse, OrderedDifferenceSemigroup,
  OrderedMultiplicativeInverse, OrderedQuotientSemigroup,
}

/**
  * Evidence that [[Nothing]] vacuously forms the identity-free ring-like
  * structures, as no values of this type exist.
  *
  * @note
  *   [[Nothing]] cannot form any structure with an identity (e.g. `0` or `1`),
  *   as this would require an actual value of type [[Nothing]] to exist.
  */
trait NothingIsIdentityFreeAlgebra:

  given OrderedDifferenceSemigroup[Nothing], OrderedQuotientSemigroup[Nothing],
          OrderedAdditiveInverse[Nothing],
          OrderedMultiplicativeInverse[Nothing]:

    private def error = throw IllegalStateException()

    override def compare(x: Nothing, y: Nothing): Int = error

    extension (x: Nothing)

      override def add(y: Nothing): Nothing      = error
      override def subtract(y: Nothing): Nothing = error
      override def negate: Nothing               = error
      override def mul(y: Nothing): Nothing      = error
      override def div(y: Nothing): Nothing      = error
      override def reciprocal: Nothing           = error
