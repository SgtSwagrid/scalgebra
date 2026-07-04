package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.Semiring

/**
  * Evidence that single-argument functions form a [[Semiring]] under pointwise
  * addition and multiplication, provided the return type has a [[Semiring]]
  * instance.
  */
trait FunctionIsSemiring:

  given [X, Y : Semiring as Y] => Semiring[X => Y]:

    override def zero: X => Y = _ => Y.zero
    override def one: X => Y  = _ => Y.one

    extension (f: X => Y)

      override def add(g: X => Y): X => Y = x => f(x) + g(x)
      override def mul(g: X => Y): X => Y = x => f(x) * g(x)
