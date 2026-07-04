package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.AdditiveSemigroup

/**
  * Evidence that single-argument functions form an [[AdditiveSemigroup]] under
  * pointwise addition, provided the return type has an [[AdditiveSemigroup]]
  * instance.
  */
trait FunctionIsAdditiveSemigroup:

  given [X, Y : AdditiveSemigroup as Y] => AdditiveSemigroup[X => Y]:
    extension (f: X => Y) override def add(g: X => Y): X => Y = x => f(x) + g(x)
