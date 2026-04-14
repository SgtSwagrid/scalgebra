package io.github.sgtswagrid.structures
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Ring]] under pointwise negation,
  * addition, and multiplication, provided the result type has a [[Ring]]
  * instance.
  */
trait FutureIsRing:

  given [X : Ring as X](using ExecutionContext): Ring[Future[X]] with

    override def zero: Future[X] = Future.successful(X.zero)

    override def one: Future[X] = Future.successful(X.one)

    override def add(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.add(a, b))

    override def multiply(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.multiply(a, b))

    override def negate(x: Future[X]): Future[X] = x.map(X.negate)
