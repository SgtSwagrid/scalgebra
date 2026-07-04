package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.Pseudoring

/**
  * Evidence that single-argument functions form a [[Pseudoring]] under
  * pointwise negation, addition, and multiplication, provided the return type
  * has a [[Pseudoring]] instance.
  */
trait FunctionIsPseudoring:

  given [X, Y : Pseudoring as Y] => Pseudoring[X => Y]:

    override def zero: X => Y = _ => Y.zero

    extension (f: X => Y)

      override def add(g: X => Y): X => Y = x => f(x) + g(x)
      override def mul(g: X => Y): X => Y = x => f(x) * g(x)
      override def negate: X => Y         = x => f(x).negate
