package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.Pseudoring
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Pseudoring]] under pointwise negation,
  * addition, and multiplication, provided the result type has a [[Pseudoring]]
  * instance.
  */
trait FutureIsPseudoring:

  given [X : Pseudoring as X] => ExecutionContext => Pseudoring[Future[X]]:

    override def zero: Future[X] = Future.successful(X.zero)

    extension (x: Future[X])

      override def add(y: Future[X]): Future[X] = x.zip(y).map(_ + _)
      override def mul(y: Future[X]): Future[X] = x.zip(y).map(_ * _)
      override def negate: Future[X]            = x.map(_.negate)
