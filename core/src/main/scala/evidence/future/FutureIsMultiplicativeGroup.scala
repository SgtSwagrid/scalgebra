package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[MultiplicativeGroup]] under pointwise
  * multiplication and reciprocation, provided the result type has a
  * [[MultiplicativeGroup]] instance.
  */
trait FutureIsMultiplicativeGroup:

  given [X : MultiplicativeGroup as X]
    (using ExecutionContext)
    : MultiplicativeGroup[Future[X]] with

    override def one: Future[X] = Future.successful(X.one)

    override def multiply(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.multiply(a, b))

    override def reciprocate(x: Future[X]): Future[X] = x.map(X.reciprocate)
