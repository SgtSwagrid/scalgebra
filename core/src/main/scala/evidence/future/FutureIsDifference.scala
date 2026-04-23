package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Difference]] under pointwise subtraction,
  * provided the result type has a [[Difference]] instance.
  */
trait FutureIsDifference:

  given [X : Difference as X]
    (using ExecutionContext)
    : Difference[Future[X]] with

    override def subtract(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.subtract(a, b))
