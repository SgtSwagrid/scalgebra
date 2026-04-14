package io.github.sgtswagrid.structures
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms an [[EuclideanRing]] under pointwise
  * addition, negation, multiplication, and division, provided the result type
  * has an [[EuclideanRing]] instance.
  */
trait FutureIsEuclideanRing:

  given [X : EuclideanRing as X]
    (using ExecutionContext)
    : EuclideanRing[Future[X]] with

    override def zero: Future[X] = Future.successful(X.zero)

    override def one: Future[X] = Future.successful(X.one)

    override def add(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.add(a, b))

    override def negate(x: Future[X]): Future[X] = x.map(X.negate)

    override def multiply(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.multiply(a, b))

    override def divide(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.divide(a, b))
