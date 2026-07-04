package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeGroup
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[MultiplicativeGroup]] under pointwise
  * multiplication and reciprocation, provided the result type has a
  * [[MultiplicativeGroup]] instance.
  */
trait FutureIsMultiplicativeGroup:

  given [X : MultiplicativeGroup as X] => ExecutionContext
    => MultiplicativeGroup[Future[X]]:

    override def one: Future[X] = Future.successful(X.one)

    extension (x: Future[X])

      override def mul(y: Future[X]): Future[X] = x.zip(y).map(_ * _)
      override def reciprocal: Future[X]        = x.map(_.reciprocal)
