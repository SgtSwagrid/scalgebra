package io.github.sgtswagrid.structures
package evidence
package future

import scala.concurrent.Future

/**
  * Evidence that [[Future]] has a multiplicative identity when its result type
  * has a [[MultiplicativeIdentity]] instance.
  *
  * `one` is an already-completed future wrapping
  * [[MultiplicativeIdentity.one]].
  */
trait FutureIsMultiplicativeIdentity:

  given [X : MultiplicativeIdentity as X]: MultiplicativeIdentity[Future[X]]
  with

    override def one: Future[X] = Future.successful(X.one)
