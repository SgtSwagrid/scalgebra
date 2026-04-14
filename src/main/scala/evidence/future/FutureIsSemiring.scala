package io.github.sgtswagrid.structures
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Semiring]] under pointwise addition and
  * multiplication, provided the result type has a [[Semiring]] instance.
  */
trait FutureIsSemiring:

  given [X : Semiring as X](using ExecutionContext): Semiring[Future[X]] with

    override def zero: Future[X] = Future.successful(X.zero)

    override def one: Future[X] = Future.successful(X.one)

    override def add(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.add(a, b))

    override def multiply(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.multiply(a, b))
