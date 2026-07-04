package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeMonoid
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[MultiplicativeMonoid]] under pointwise
  * multiplication, provided the result type has a [[MultiplicativeMonoid]]
  * instance.
  */
trait FutureIsMultiplicativeMonoid:

  given [X : MultiplicativeMonoid as X] => ExecutionContext
    => MultiplicativeMonoid[Future[X]]:

    override def one: Future[X] = Future.successful(X.one)

    extension (x: Future[X])
      override def mul(y: Future[X]): Future[X] = x.zip(y).map(_ * _)
