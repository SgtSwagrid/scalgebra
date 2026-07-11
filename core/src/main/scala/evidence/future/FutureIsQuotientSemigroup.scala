package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.QuotientSemigroup
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[QuotientSemigroup]] under pointwise
  * multiplication and division, provided the result type has an
  * [[QuotientSemigroup]] instance.
  */
trait FutureIsQuotientSemigroup:

  given [X : QuotientSemigroup as X] => ExecutionContext
    => QuotientSemigroup[Future[X]]:

    extension (x: Future[X])

      override def mul(y: Future[X]): Future[X] = x.zip(y).map(_ * _)
      override def div(y: Future[X]): Future[X] = x.zip(y).map(_ / _)
