package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.AdditiveSemigroup
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms an [[AdditiveSemigroup]] under pointwise
  * addition, provided the result type has an [[AdditiveSemigroup]] instance.
  */
trait FutureIsAdditiveSemigroup:

  given [X : AdditiveSemigroup as X] => ExecutionContext
    => AdditiveSemigroup[Future[X]]:

    extension (x: Future[X])
      override def add(y: Future[X]): Future[X] = x.zip(y).map(_ + _)
