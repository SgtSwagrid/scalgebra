package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.Field
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Field]] under pointwise addition,
  * negation, multiplication, and reciprocation, provided the result type has a
  * [[Field]] instance.
  */
trait FutureIsField:

  given [X : Field as X] => ExecutionContext => Field[Future[X]]:

    override def zero: Future[X] = Future.successful(X.zero)
    override def one: Future[X]  = Future.successful(X.one)

    extension (x: Future[X])

      override def add(y: Future[X]): Future[X] = x.zip(y).map(_ + _)
      override def negate: Future[X]            = x.map(_.negate)
      override def mul(y: Future[X]): Future[X] = x.zip(y).map(_ * _)
      override def reciprocal: Future[X]        = x.map(_.reciprocal)
