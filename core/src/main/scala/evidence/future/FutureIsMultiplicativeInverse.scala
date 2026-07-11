package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeInverse
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] has a [[MultiplicativeInverse]] under pointwise
  * reciprocation, provided the result type has a [[MultiplicativeInverse]]
  * instance.
  */
trait FutureIsMultiplicativeInverse:

  given [X : MultiplicativeInverse as X] => ExecutionContext
    => MultiplicativeInverse[Future[X]]:

    extension (x: Future[X])
      override def reciprocal: Future[X] = x.map(_.reciprocal)
