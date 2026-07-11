package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.QuotientDifferenceSemiring

/**
  * Evidence that single-argument functions form a
  * [[QuotientDifferenceSemiring]] under pointwise addition, subtraction,
  * multiplication, and division, provided the return type has a
  * [[QuotientDifferenceSemiring]] instance.
  */
trait FunctionIsQuotientDifferenceSemiring:

  given [X, Y : QuotientDifferenceSemiring as Y]
    => QuotientDifferenceSemiring[X => Y]:

    override def zero: X => Y = _ => Y.zero
    override def one: X => Y  = _ => Y.one

    extension (f: X => Y)

      override def add(g: X => Y): X => Y      = x => f(x) + g(x)
      override def subtract(g: X => Y): X => Y = x => f(x) - g(x)
      override def mul(g: X => Y): X => Y      = x => f(x) * g(x)
      override def div(g: X => Y): X => Y      = x => f(x) / g(x)
