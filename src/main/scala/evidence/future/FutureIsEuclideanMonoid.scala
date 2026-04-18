package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms an [[EuclideanMonoid]] under pointwise
  * multiplication and division, provided the result type has an
  * [[EuclideanMonoid]] instance.
  */
trait FutureIsEuclideanMonoid:

  given [X : EuclideanMonoid as X]
    (using ExecutionContext)
    : EuclideanMonoid[Future[X]] with

    override def one: Future[X] = Future.successful(X.one)

    override def multiply(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.multiply(a, b))

    override def divide(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.divide(a, b))
