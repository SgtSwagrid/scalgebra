package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.DifferenceMonoid

/**
  * Evidence that single-argument functions form a [[DifferenceMonoid]] under
  * pointwise addition and subtraction, provided the return type has a
  * [[DifferenceMonoid]] instance.
  */
trait FunctionIsDifferenceMonoid:

  given [X, Y : DifferenceMonoid as Y] => DifferenceMonoid[X => Y]:

    override def zero: X => Y = _ => Y.zero

    extension (f: X => Y)

      override def add(g: X => Y): X => Y      = x => f(x) + g(x)
      override def subtract(g: X => Y): X => Y = x => f(x) - g(x)
