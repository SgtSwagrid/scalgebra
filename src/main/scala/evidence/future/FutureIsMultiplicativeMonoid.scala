package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[MultiplicativeMonoid]] under pointwise
  * multiplication, provided the result type has a [[MultiplicativeMonoid]]
  * instance.
  */
trait FutureIsMultiplicativeMonoid:

  given [X : MultiplicativeMonoid as X]
    (using ExecutionContext)
    : MultiplicativeMonoid[Future[X]] with

    override def one: Future[X] = Future.successful(X.one)

    override def multiply(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.multiply(a, b))
