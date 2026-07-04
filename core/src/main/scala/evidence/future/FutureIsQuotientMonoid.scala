package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.QuotientMonoid
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[QuotientMonoid]] under pointwise
  * multiplication and division, provided the result type has an
  * [[QuotientMonoid]] instance.
  */
trait FutureIsQuotientMonoid:

  given [X : QuotientMonoid as X] => ExecutionContext
    => QuotientMonoid[Future[X]]:

    override def one: Future[X] = Future.successful(X.one)

    extension (x: Future[X])

      override def mul(y: Future[X]): Future[X] = x.zip(y).map(_ * _)
      override def div(y: Future[X]): Future[X] = x.zip(y).map(_ / _)
