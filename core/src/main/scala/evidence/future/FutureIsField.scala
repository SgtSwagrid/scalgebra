package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Field]] under pointwise addition,
  * negation, multiplication, and reciprocation, provided the result type has a
  * [[Field]] instance.
  */
trait FutureIsField:

  given [X : Field as X](using ExecutionContext): Field[Future[X]] with

    override def zero: Future[X] = Future.successful(X.zero)

    override def one: Future[X] = Future.successful(X.one)

    override def add(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.add(a, b))

    override def negate(x: Future[X]): Future[X] = x.map(X.negate)

    override def multiply(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.multiply(a, b))

    override def reciprocate(x: Future[X]): Future[X] = x.map(X.reciprocate)
