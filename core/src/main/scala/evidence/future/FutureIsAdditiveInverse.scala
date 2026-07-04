package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.AdditiveInverse
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] has an [[AdditiveInverse]] under pointwise
  * negation, provided the result type has an [[AdditiveInverse]] instance.
  */
trait FutureIsAdditiveInverse:

  given [X : AdditiveInverse as X] => ExecutionContext
    => AdditiveInverse[Future[X]]:
    extension (x: Future[X]) override def negate: Future[X] = x.map(_.negate)
