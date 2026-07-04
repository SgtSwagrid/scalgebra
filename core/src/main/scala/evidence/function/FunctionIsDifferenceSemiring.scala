package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.DifferenceSemiring

/**
  * Evidence that single-argument functions form a [[DifferenceSemiring]] under
  * pointwise addition, subtraction, and multiplication, provided the return
  * type has a [[DifferenceSemiring]] instance.
  */
trait FunctionIsDifferenceSemiring:

  given [X, Y : DifferenceSemiring as Y] => DifferenceSemiring[X => Y]:

    override def zero: X => Y = _ => Y.zero
    override def one: X => Y  = _ => Y.one

    extension (f: X => Y)

      override def add(g: X => Y): X => Y      = x => f(x) + g(x)
      override def subtract(g: X => Y): X => Y = x => f(x) - g(x)
      override def mul(g: X => Y): X => Y      = x => f(x) * g(x)
