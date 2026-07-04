package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeMonoid

/**
  * Evidence that single-argument functions form a [[MultiplicativeMonoid]]
  * under pointwise multiplication, provided the return type has a
  * [[MultiplicativeMonoid]] instance.
  */
trait FunctionIsMultiplicativeMonoid:

  given [X, Y : MultiplicativeMonoid as Y] => MultiplicativeMonoid[X => Y]:

    override def one: X => Y = _ => Y.one

    extension (f: X => Y) override def mul(g: X => Y): X => Y = x => f(x) * g(x)
