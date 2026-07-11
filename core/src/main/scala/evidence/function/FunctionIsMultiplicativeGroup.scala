package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeGroup

/**
  * Evidence that single-argument functions form a [[MultiplicativeGroup]] under
  * pointwise reciprocation and multiplication, provided the return type has a
  * [[MultiplicativeGroup]] instance.
  */
trait FunctionIsMultiplicativeGroup:

  given [X, Y : MultiplicativeGroup as Y] => MultiplicativeGroup[X => Y]:

    override def one: X => Y = _ => Y.one

    extension (f: X => Y)

      override def mul(g: X => Y): X => Y = x => f(x) * g(x)
      override def reciprocal: X => Y     = x => f(x).reciprocal
