package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.AdditiveGroup
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms an [[AdditiveGroup]] under pointwise negation
  * and addition, provided the result type has an [[AdditiveGroup]] instance.
  */
trait FutureIsAdditiveGroup:

  given [X : AdditiveGroup as X] => ExecutionContext
    => AdditiveGroup[Future[X]]:

    override def zero: Future[X] = Future.successful(X.zero)

    extension (x: Future[X])

      override def add(y: Future[X]): Future[X] = x.zip(y).map(_ + _)
      override def negate: Future[X]            = x.map(_.negate)
