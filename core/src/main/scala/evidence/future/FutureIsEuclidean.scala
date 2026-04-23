package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Euclidean]] under pointwise division,
  * provided the result type has a [[Euclidean]] instance.
  */
trait FutureIsEuclidean:

  given [X : Euclidean as X](using ExecutionContext): Euclidean[Future[X]] with

    override def divide(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.divide(a, b))
