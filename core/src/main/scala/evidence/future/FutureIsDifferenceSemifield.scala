package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[DifferenceSemifield]] under pointwise
  * addition, subtraction, multiplication, and reciprocation, provided the
  * result type has a [[DifferenceSemifield]] instance.
  */
trait FutureIsDifferenceSemifield:

  given [X : DifferenceSemifield as X]
    (using ExecutionContext)
    : DifferenceSemifield[Future[X]] with

    override def zero: Future[X] = Future.successful(X.zero)

    override def one: Future[X] = Future.successful(X.one)

    override def add(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.add(a, b))

    override def subtract(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.subtract(a, b))

    override def multiply(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.multiply(a, b))

    override def reciprocate(x: Future[X]): Future[X] = x.map(X.reciprocate)
