package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.DifferenceSemifield

/**
  * Evidence that single-argument functions form a [[DifferenceSemifield]] under
  * pointwise addition, subtraction, multiplication, and reciprocation, provided
  * the return type has a [[DifferenceSemifield]] instance.
  */
trait FunctionIsDifferenceSemifield:

  given [X, Y : DifferenceSemifield as Y] => DifferenceSemifield[X => Y]:

    override def zero: X => Y = _ => Y.zero
    override def one: X => Y  = _ => Y.one

    extension (f: X => Y)

      override def add(g: X => Y): X => Y      = x => f(x) + g(x)
      override def subtract(g: X => Y): X => Y = x => f(x) - g(x)
      override def mul(g: X => Y): X => Y      = x => f(x) * g(x)
      override def reciprocal: X => Y          = x => f(x).reciprocal
