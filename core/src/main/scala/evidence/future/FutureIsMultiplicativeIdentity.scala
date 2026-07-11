package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeIdentity
import scala.concurrent.Future

/**
  * Evidence that [[Future]] has a [[MultiplicativeIdentity]], provided the
  * result type has a [[MultiplicativeIdentity]] instance.
  *
  * `one` is an already-completed future wrapping
  * [[MultiplicativeIdentity.one]].
  */
trait FutureIsMultiplicativeIdentity:

  given [X : MultiplicativeIdentity as X] => MultiplicativeIdentity[Future[X]]:
    override def one: Future[X] = Future.successful(X.one)
