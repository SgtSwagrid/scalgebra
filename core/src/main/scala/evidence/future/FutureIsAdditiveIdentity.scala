package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.AdditiveIdentity
import scala.concurrent.Future

/**
  * Evidence that [[Future]] has an [[AdditiveIdentity]], provided the result
  * type has an [[AdditiveIdentity]] instance.
  *
  * `zero` is an already-completed future wrapping [[AdditiveIdentity.zero]].
  */
trait FutureIsAdditiveIdentity:

  given [X : AdditiveIdentity as X] => AdditiveIdentity[Future[X]]:
    override def zero: Future[X] = Future.successful(X.zero)
