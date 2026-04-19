package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] has an additive inverse under pointwise negation,
  * provided the result type has an [[AdditiveInverse]] instance.
  */
trait FutureIsAdditiveInverse:

  given [X : AdditiveInverse as X]
    (using ExecutionContext)
    : AdditiveInverse[Future[X]] with

    override def negate(x: Future[X]): Future[X] = x.map(X.negate)
