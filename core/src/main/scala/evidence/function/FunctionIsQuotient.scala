package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.Quotient

/**
  * Evidence that single-argument functions form a [[Quotient]] under pointwise
  * division, provided the return type has a [[Quotient]] instance.
  */
trait FunctionIsQuotient:

  given [X, Y : Quotient as Y] => Quotient[X => Y]:

    extension (f: X => Y) override def div(g: X => Y): X => Y = x => f(x) / g(x)
