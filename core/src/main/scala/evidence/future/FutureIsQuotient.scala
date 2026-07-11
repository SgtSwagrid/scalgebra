package com.alecdorrington.scalgebra
package evidence
package future

import com.alecdorrington.scalgebra.arithmetic.Quotient
import scala.concurrent.{ExecutionContext, Future}

/**
  * Evidence that [[Future]] forms a [[Quotient]] under pointwise division,
  * provided the result type has a [[Quotient]] instance.
  */
trait FutureIsQuotient:

  given [X : Quotient as X] => ExecutionContext => Quotient[Future[X]]:

    extension (x: Future[X])
      override def div(y: Future[X]): Future[X] = x.zip(y).map(_ / _)
