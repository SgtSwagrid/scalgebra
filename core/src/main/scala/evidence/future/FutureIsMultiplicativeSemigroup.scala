package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeSemigroup
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[MultiplicativeSemigroup]] under pointwise
  * multiplication, provided the result type has a [[MultiplicativeSemigroup]]
  * instance.
  */
trait FutureIsMultiplicativeSemigroup:

  given [X : MultiplicativeSemigroup as X] => ExecutionContext
    => MultiplicativeSemigroup[Future[X]]:

    extension (x: Future[X])
      override def mul(y: Future[X]): Future[X] = x.zip(y).map(_ * _)
