package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.QuotientRing

/**
  * Evidence that single-argument functions form a [[QuotientRing]] under
  * pointwise addition, negation, multiplication, and division, provided the
  * return type has a [[QuotientRing]] instance.
  */
trait FunctionIsQuotientRing:

  given [X, Y : QuotientRing as Y] => QuotientRing[X => Y]:

    override def zero: X => Y = _ => Y.zero
    override def one: X => Y  = _ => Y.one

    extension (f: X => Y)

      override def add(g: X => Y): X => Y = x => f(x) + g(x)
      override def negate: X => Y         = x => f(x).negate
      override def mul(g: X => Y): X => Y = x => f(x) * g(x)
      override def div(g: X => Y): X => Y = x => f(x) / g(x)
