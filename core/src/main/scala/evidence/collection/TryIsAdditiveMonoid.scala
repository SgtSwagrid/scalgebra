package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.arithmetic.{
  AdditiveMonoid, AdditiveSemigroup,
}
import scala.util.{Failure, Success, Try}

/**
  * Evidence that [[Try]] forms an [[AdditiveMonoid]] under success-combining
  * addition, provided the result type has an [[AdditiveMonoid]] instance.
  * [[Failure]] is absorbing, keeping the first failure encountered.
  *
  * Since [[Throwable]] has no [[AdditiveSemigroup]], two [[Failure]] values
  * cannot be combined meaningfully; the left-hand failure is kept.
  */
trait TryIsAdditiveMonoid:

  given [X : AdditiveMonoid as X] => AdditiveMonoid[Try[X]]:

    override def zero: Try[X] = Success(X.zero)

    extension (x: Try[X])

      override def add(y: Try[X]): Try[X] = (x, y) match
        case (Success(x1), Success(x2)) => Success(x1 + x2)
        case (Failure(e), _)            => Failure(e)
        case (_, f)                     => f
