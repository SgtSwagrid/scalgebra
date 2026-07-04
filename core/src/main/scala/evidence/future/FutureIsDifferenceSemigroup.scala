package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.DifferenceSemigroup
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[DifferenceSemigroup]] under pointwise
  * addition and subtraction, provided the result type has a
  * [[DifferenceSemigroup]] instance.
  */
trait FutureIsDifferenceSemigroup:

  given [X : DifferenceSemigroup as X] => ExecutionContext
    => DifferenceSemigroup[Future[X]]:

    extension (x: Future[X])

      override def add(y: Future[X]): Future[X]      = x.zip(y).map(_ + _)
      override def subtract(y: Future[X]): Future[X] = x.zip(y).map(_ - _)
