package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.QuotientDifferenceSemiring
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[QuotientDifferenceSemiring]] under
  * pointwise addition, subtraction, multiplication, and division, provided the
  * result type has a [[QuotientDifferenceSemiring]] instance.
  */
trait FutureIsQuotientDifferenceSemiring:

  given [X : QuotientDifferenceSemiring as X] => ExecutionContext
    => QuotientDifferenceSemiring[Future[X]]:

    override def zero: Future[X] = Future.successful(X.zero)
    override def one: Future[X]  = Future.successful(X.one)

    extension (x: Future[X])

      override def add(y: Future[X]): Future[X]      = x.zip(y).map(_ + _)
      override def subtract(y: Future[X]): Future[X] = x.zip(y).map(_ - _)
      override def mul(y: Future[X]): Future[X]      = x.zip(y).map(_ * _)
      override def div(y: Future[X]): Future[X]      = x.zip(y).map(_ / _)
