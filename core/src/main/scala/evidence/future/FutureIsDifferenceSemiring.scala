package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.DifferenceSemiring
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[DifferenceSemiring]] under pointwise
  * addition, subtraction, and multiplication, provided the result type has a
  * [[DifferenceSemiring]] instance.
  */
trait FutureIsDifferenceSemiring:

  given [X : DifferenceSemiring as X] => ExecutionContext
    => DifferenceSemiring[Future[X]]:

    override def zero: Future[X] = Future.successful(X.zero)
    override def one: Future[X]  = Future.successful(X.one)

    extension (x: Future[X])

      override def add(y: Future[X]): Future[X]      = x.zip(y).map(_ + _)
      override def subtract(y: Future[X]): Future[X] = x.zip(y).map(_ - _)
      override def mul(y: Future[X]): Future[X]      = x.zip(y).map(_ * _)
