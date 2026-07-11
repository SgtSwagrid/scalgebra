package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.DifferenceSemigroup

/**
  * Evidence that single-argument functions form a [[DifferenceSemigroup]] under
  * pointwise addition and subtraction, provided the return type has a
  * [[DifferenceSemigroup]] instance.
  */
trait FunctionIsDifferenceSemigroup:

  given [X, Y : DifferenceSemigroup as Y] => DifferenceSemigroup[X => Y]:

    extension (f: X => Y)

      override def add(g: X => Y): X => Y      = x => f(x) + g(x)
      override def subtract(g: X => Y): X => Y = x => f(x) - g(x)
