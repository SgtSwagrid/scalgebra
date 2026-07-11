package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.Semifield
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Semifield]] under pointwise addition,
  * multiplication, and reciprocation, provided the result type has a
  * [[Semifield]] instance.
  */
trait FutureIsSemifield:

  given [X : Semifield as X] => ExecutionContext => Semifield[Future[X]]:

    override def zero: Future[X] = Future.successful(X.zero)
    override def one: Future[X]  = Future.successful(X.one)

    extension (x: Future[X])

      override def add(y: Future[X]): Future[X] = x.zip(y).map(_ + _)
      override def mul(y: Future[X]): Future[X] = x.zip(y).map(_ * _)
      override def reciprocal: Future[X]        = x.map(_.reciprocal)
