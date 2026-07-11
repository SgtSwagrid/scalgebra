package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.QuotientRing
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[QuotientRing]] under pointwise addition,
  * negation, multiplication, and division, provided the result type has a
  * [[QuotientRing]] instance.
  */
trait FutureIsQuotientRing:

  given [X : QuotientRing as X] => ExecutionContext => QuotientRing[Future[X]]:

    override def zero: Future[X] = Future.successful(X.zero)
    override def one: Future[X]  = Future.successful(X.one)

    extension (x: Future[X])

      override def add(y: Future[X]): Future[X] = x.zip(y).map(_ + _)
      override def negate: Future[X]            = x.map(_.negate)
      override def mul(y: Future[X]): Future[X] = x.zip(y).map(_ * _)
      override def div(y: Future[X]): Future[X] = x.zip(y).map(_ / _)
