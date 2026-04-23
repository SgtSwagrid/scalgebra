package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms an [[EuclideanSemigroup]] under pointwise
  * multiplication and division, provided the result type has an
  * [[EuclideanSemigroup]] instance.
  */
trait FutureIsEuclideanSemigroup:

  given [X : EuclideanSemigroup as X]
    (using ExecutionContext)
    : EuclideanSemigroup[Future[X]] with

    override def multiply(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.multiply(a, b))

    override def divide(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.divide(a, b))
