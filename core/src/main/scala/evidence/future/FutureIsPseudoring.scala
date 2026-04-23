package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Pseudoring]] under pointwise negation,
  * addition, and multiplication, provided the result type has a [[Pseudoring]]
  * instance.
  */
trait FutureIsPseudoring:

  given [X : Pseudoring as X]
    (using ExecutionContext)
    : Pseudoring[Future[X]] with

    override def zero: Future[X] = Future.successful(X.zero)

    override def add(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.add(a, b))

    override def multiply(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.multiply(a, b))

    override def negate(x: Future[X]): Future[X] = x.map(X.negate)
