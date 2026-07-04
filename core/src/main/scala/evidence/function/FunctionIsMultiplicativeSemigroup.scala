package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeSemigroup

/**
  * Evidence that single-argument functions form a [[MultiplicativeSemigroup]]
  * under pointwise multiplication, provided the return type has a
  * [[MultiplicativeSemigroup]] instance.
  */
trait FunctionIsMultiplicativeSemigroup:

  given [X, Y : MultiplicativeSemigroup as Y]
    => MultiplicativeSemigroup[X => Y]:

    extension (f: X => Y) override def mul(g: X => Y): X => Y = x => f(x) * g(x)
