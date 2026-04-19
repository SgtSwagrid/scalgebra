package com.alecdorrington.scalgebra
package evidence
package future

import scala.concurrent.Future

/**
  * Evidence that [[Future]] has an additive identity when its result type has
  * an [[AdditiveIdentity]] instance.
  *
  * `zero` is an already-completed future wrapping [[AdditiveIdentity.zero]].
  */
trait FutureIsAdditiveIdentity:

  given [X : AdditiveIdentity as X]: AdditiveIdentity[Future[X]] with

    override def zero: Future[X] = Future.successful(X.zero)
