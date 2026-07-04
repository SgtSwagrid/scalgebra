package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.Ring
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Ring]] under pointwise negation,
  * addition, and multiplication, provided the result type has a [[Ring]]
  * instance.
  */
trait FutureIsRing:

  given [X : Ring as X] => ExecutionContext => Ring[Future[X]]:

    override def zero: Future[X] = Future.successful(X.zero)
    override def one: Future[X]  = Future.successful(X.one)

    extension (x: Future[X])

      override def add(y: Future[X]): Future[X] = x.zip(y).map(_ + _)
      override def mul(y: Future[X]): Future[X] = x.zip(y).map(_ * _)
      override def negate: Future[X]            = x.map(_.negate)
