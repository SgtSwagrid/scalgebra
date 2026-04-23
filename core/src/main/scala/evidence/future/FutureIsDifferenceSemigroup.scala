package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[DifferenceSemigroup]] under pointwise
  * addition and subtraction, provided the result type has a
  * [[DifferenceSemigroup]] instance.
  */
trait FutureIsDifferenceSemigroup:

  given [X : DifferenceSemigroup as X]
    (using ExecutionContext)
    : DifferenceSemigroup[Future[X]] with

    override def add(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.add(a, b))

    override def subtract(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.subtract(a, b))
