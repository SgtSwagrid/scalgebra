package io.github.sgtswagrid.structures
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Semifield]] under pointwise addition,
  * multiplication, and reciprocation, provided the result type has a
  * [[Semifield]] instance.
  */
trait FutureIsSemifield:

  given [X : Semifield as X](using ExecutionContext): Semifield[Future[X]] with

    override def zero: Future[X] = Future.successful(X.zero)

    override def one: Future[X] = Future.successful(X.one)

    override def add(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.add(a, b))

    override def multiply(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.multiply(a, b))

    override def reciprocate(x: Future[X]): Future[X] = x.map(X.reciprocate)
