package io.github.sgtswagrid.structures
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[MultiplicativeSemigroup]] under pointwise
  * multiplication, provided the result type has a [[MultiplicativeSemigroup]]
  * instance.
  */
trait FutureIsMultiplicativeSemigroup:

  given [X : MultiplicativeSemigroup as X]
    (using ExecutionContext)
    : MultiplicativeSemigroup[Future[X]] with

    override def multiply(x: Future[X], y: Future[X]): Future[X] = x
      .zip(y)
      .map((a, b) => X.multiply(a, b))
