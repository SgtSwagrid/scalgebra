package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms an [[AdditiveSemigroup]] under pointwise
  * addition, provided the result type has an [[AdditiveSemigroup]] instance.
  */
trait FutureIsAdditiveSemigroup:

  given [X : AdditiveSemigroup as X]
    (using ExecutionContext)
    : AdditiveSemigroup[Future[X]] with

    override def add(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.add(a, b))
