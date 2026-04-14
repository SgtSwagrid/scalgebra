package io.github.sgtswagrid.structures
package evidence
package future

import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] has a multiplicative inverse under pointwise
  * reciprocation, provided the result type has a [[MultiplicativeInverse]]
  * instance.
  */
trait FutureIsMultiplicativeInverse:

  given [X : MultiplicativeInverse as X]
    (using ExecutionContext)
    : MultiplicativeInverse[Future[X]] with

    override def reciprocate(x: Future[X]): Future[X] = x.map(X.reciprocate)
