package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms an [[AdditiveMonoid]] under pointwise
  * addition, provided the result type has an [[AdditiveMonoid]] instance.
  *
  * The two futures are awaited concurrently and their results combined; `zero`
  * is an already-completed future wrapping [[AdditiveMonoid.zero]]. Requires an
  * implicit [[ExecutionContext]] for scheduling the combination.
  */
trait FutureIsAdditiveMonoid:

  given [X : AdditiveMonoid as X]
    (using ExecutionContext)
    : AdditiveMonoid[Future[X]] with

    override def zero: Future[X] = Future.successful(X.zero)

    override def add(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.add(a, b))
