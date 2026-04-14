package io.github.sgtswagrid.structures
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[DifferenceMonoid]] under pointwise
  * addition and subtraction, provided the result type has a
  * [[DifferenceMonoid]] instance.
  */
trait FutureIsDifferenceMonoid:

  given [X : DifferenceMonoid as X]
    (using ExecutionContext)
    : DifferenceMonoid[Future[X]] with

    override def zero: Future[X] = Future.successful(X.zero)

    override def add(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.add(a, b))

    override def subtract(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.subtract(a, b))
