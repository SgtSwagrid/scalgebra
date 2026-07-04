package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.Semifield

/**
  * Evidence that single-argument functions form a [[Semifield]] under pointwise
  * addition, multiplication, and reciprocation, provided the return type has a
  * [[Semifield]] instance.
  */
trait FunctionIsSemifield:

  given [X, Y : Semifield as Y] => Semifield[X => Y]:

    override def zero: X => Y = _ => Y.zero
    override def one: X => Y  = _ => Y.one

    extension (f: X => Y)

      override def add(g: X => Y): X => Y = x => f(x) + g(x)
      override def mul(g: X => Y): X => Y = x => f(x) * g(x)
      override def reciprocal: X => Y     = x => f(x).reciprocal
