package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.Semiring
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Semiring]] under pointwise addition and
  * multiplication, provided the result type has a [[Semiring]] instance.
  */
trait FutureIsSemiring:

  given [X : Semiring as X] => ExecutionContext => Semiring[Future[X]]:

    override def zero: Future[X] = Future.successful(X.zero)
    override def one: Future[X]  = Future.successful(X.one)

    extension (x: Future[X])

      override def add(y: Future[X]): Future[X] = x.zip(y).map(_ + _)
      override def mul(y: Future[X]): Future[X] = x.zip(y).map(_ * _)
