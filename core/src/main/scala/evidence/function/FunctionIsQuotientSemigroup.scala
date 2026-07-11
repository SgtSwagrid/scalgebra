package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.QuotientSemigroup

/**
  * Evidence that single-argument functions form a [[QuotientSemigroup]] under
  * pointwise multiplication and division, provided the return type has an
  * [[QuotientSemigroup]] instance.
  */
trait FunctionIsQuotientSemigroup:

  given [X, Y : QuotientSemigroup as Y] => QuotientSemigroup[X => Y]:

    extension (f: X => Y)

      override def mul(g: X => Y): X => Y = x => f(x) * g(x)
      override def div(g: X => Y): X => Y = x => f(x) / g(x)
