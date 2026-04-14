package io.github.sgtswagrid.structures
package evidence
package collection

import scala.util.{Failure, Success, Try}

/**
  * Evidence that [[Try]] forms an [[AdditiveMonoid]] where [[Success]] values
  * are combined and [[Failure]] is absorbing, keeping the first failure
  * encountered.
  *
  * Since [[Throwable]] has no [[AdditiveSemigroup]], two [[Failure]] values
  * cannot be combined meaningfully; the left-hand failure is kept.
  */
trait TryIsAdditiveMonoid:

  given [X : AdditiveMonoid as X]: AdditiveMonoid[Try[X]] with

    override def zero: Try[X] = Success(X.zero)

    override def add(x: Try[X], y: Try[X]): Try[X] = (x, y) match
      case (Success(x1), Success(x2)) => Success(X.add(x1, x2))
      case (Failure(e), _)            => Failure(e)
      case (_, f)                     => f
