package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.Difference

/**
  * Evidence that single-argument functions form a [[Difference]] under
  * pointwise subtraction, provided the return type has a [[Difference]]
  * instance.
  */
trait FunctionIsDifference:

  given [X, Y : Difference as Y] => Difference[X => Y]:

    extension (f: X => Y)
      override def subtract(g: X => Y): X => Y = x => f(x) - g(x)
