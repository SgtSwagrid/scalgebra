package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.AdditiveMonoid

/**
  * Evidence that single-argument functions form an [[AdditiveMonoid]] under
  * pointwise addition, provided the return type has an [[AdditiveMonoid]]
  * instance.
  */
trait FunctionIsAdditiveMonoid:

  given [X, Y : AdditiveMonoid as Y] => AdditiveMonoid[X => Y]:

    override def zero: X => Y                                 = _ => Y.zero
    extension (f: X => Y) override def add(g: X => Y): X => Y = x => f(x) + g(x)
