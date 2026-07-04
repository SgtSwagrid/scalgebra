package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.AdditiveMonoid
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms an [[AdditiveMonoid]] under pointwise
  * addition, provided the result type has an [[AdditiveMonoid]] instance.
  *
  * The two futures are awaited concurrently and their results combined; `zero`
  * is an already-completed future wrapping [[AdditiveMonoid.zero]].
  */
trait FutureIsAdditiveMonoid:

  given [X : AdditiveMonoid as X] => ExecutionContext
    => AdditiveMonoid[Future[X]]:

    override def zero: Future[X] = Future.successful(X.zero)

    extension (x: Future[X])
      override def add(y: Future[X]): Future[X] = x.zip(y).map(_ + _)
