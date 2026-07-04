package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.Difference
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Difference]] under pointwise subtraction,
  * provided the result type has a [[Difference]] instance.
  */
trait FutureIsDifference:

  given [X : Difference as X] => ExecutionContext => Difference[Future[X]]:

    extension (x: Future[X])
      override def subtract(y: Future[X]): Future[X] = x.zip(y).map(_ - _)
