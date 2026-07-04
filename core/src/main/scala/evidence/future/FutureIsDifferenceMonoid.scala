package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.DifferenceMonoid
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[DifferenceMonoid]] under pointwise
  * addition and subtraction, provided the result type has a
  * [[DifferenceMonoid]] instance.
  */
trait FutureIsDifferenceMonoid:

  given [X : DifferenceMonoid as X] => ExecutionContext
    => DifferenceMonoid[Future[X]]:

    override def zero: Future[X] = Future.successful(X.zero)

    extension (x: Future[X])

      override def add(y: Future[X]): Future[X]      = x.zip(y).map(_ + _)
      override def subtract(y: Future[X]): Future[X] = x.zip(y).map(_ - _)
