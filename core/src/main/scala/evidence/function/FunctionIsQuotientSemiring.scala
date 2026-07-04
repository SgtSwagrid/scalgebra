package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.QuotientSemiring

/**
  * Evidence that single-argument functions form a [[QuotientSemiring]] under
  * pointwise addition, multiplication, and division, provided the return type
  * has a [[QuotientSemiring]] instance.
  */
trait FunctionIsQuotientSemiring:

  given [X, Y : QuotientSemiring as Y] => QuotientSemiring[X => Y]:

    override def zero: X => Y = _ => Y.zero
    override def one: X => Y  = _ => Y.one

    extension (f: X => Y)

      override def add(g: X => Y): X => Y = x => f(x) + g(x)
      override def mul(g: X => Y): X => Y = x => f(x) * g(x)
      override def div(g: X => Y): X => Y = x => f(x) / g(x)
