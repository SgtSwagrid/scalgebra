package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.QuotientMonoid

/**
  * Evidence that single-argument functions form a [[QuotientMonoid]] under
  * pointwise multiplication and division, provided the return type has an
  * [[QuotientMonoid]] instance.
  */
trait FunctionIsQuotientMonoid:

  given [X, Y : QuotientMonoid as Y] => QuotientMonoid[X => Y]:

    override def one: X => Y = _ => Y.one

    extension (f: X => Y)

      override def mul(g: X => Y): X => Y = x => f(x) * g(x)
      override def div(g: X => Y): X => Y = x => f(x) / g(x)
