package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.QuotientSemiring
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[QuotientSemiring]] under pointwise
  * addition, multiplication, and division, provided the result type has a
  * [[QuotientSemiring]] instance.
  */
trait FutureIsQuotientSemiring:

  given [X : QuotientSemiring as X] => ExecutionContext
    => QuotientSemiring[Future[X]]:

    override def zero: Future[X] = Future.successful(X.zero)
    override def one: Future[X]  = Future.successful(X.one)

    extension (x: Future[X])

      override def add(y: Future[X]): Future[X] = x.zip(y).map(_ + _)
      override def mul(y: Future[X]): Future[X] = x.zip(y).map(_ * _)
      override def div(y: Future[X]): Future[X] = x.zip(y).map(_ / _)
