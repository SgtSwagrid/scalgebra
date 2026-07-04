package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.Field

/**
  * Evidence that single-argument functions form a [[Field]] under pointwise
  * addition, negation, multiplication, and reciprocation, provided the return
  * type has a [[Field]] instance.
  */
trait FunctionIsField:

  given [X, Y : Field as Y] => Field[X => Y]:

    override def zero: X => Y = _ => Y.zero
    override def one: X => Y  = _ => Y.one

    extension (f: X => Y)

      override def add(g: X => Y): X => Y = x => f(x) + g(x)
      override def negate: X => Y         = x => f(x).negate
      override def mul(g: X => Y): X => Y = x => f(x) * g(x)
      override def reciprocal: X => Y     = x => f(x).reciprocal
