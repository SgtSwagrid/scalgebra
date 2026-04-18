package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms an [[AdditiveGroup]] under pointwise negation
  * and addition, provided the result type has an [[AdditiveGroup]] instance.
  */
trait FutureIsAdditiveGroup:

  given [X : AdditiveGroup as X]
    (using ExecutionContext)
    : AdditiveGroup[Future[X]] with

    override def zero: Future[X] = Future.successful(X.zero)

    override def add(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.add(a, b))

    override def negate(x: Future[X]): Future[X] = x.map(X.negate)
