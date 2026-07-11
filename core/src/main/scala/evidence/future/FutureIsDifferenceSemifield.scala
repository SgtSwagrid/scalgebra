package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.DifferenceSemifield
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[DifferenceSemifield]] under pointwise
  * addition, subtraction, multiplication, and reciprocation, provided the
  * result type has a [[DifferenceSemifield]] instance.
  */
trait FutureIsDifferenceSemifield:

  given [X : DifferenceSemifield as X] => ExecutionContext
    => DifferenceSemifield[Future[X]]:

    override def zero: Future[X] = Future.successful(X.zero)
    override def one: Future[X]  = Future.successful(X.one)

    extension (x: Future[X])

      override def add(y: Future[X]): Future[X]      = x.zip(y).map(_ + _)
      override def subtract(y: Future[X]): Future[X] = x.zip(y).map(_ - _)
      override def mul(y: Future[X]): Future[X]      = x.zip(y).map(_ * _)
      override def reciprocal: Future[X]             = x.map(_.reciprocal)
