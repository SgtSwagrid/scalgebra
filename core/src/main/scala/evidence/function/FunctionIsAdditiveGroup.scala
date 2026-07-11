package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.AdditiveGroup

/**
  * Evidence that single-argument functions form an [[AdditiveGroup]] under
  * pointwise negation and addition, provided the return type has an
  * [[AdditiveGroup]] instance.
  */
trait FunctionIsAdditiveGroup:

  given [X, Y : AdditiveGroup as Y] => AdditiveGroup[X => Y]:

    override def zero: X => Y = _ => Y.zero

    extension (f: X => Y)

      override def add(g: X => Y): X => Y = x => f(x) + g(x)
      override def negate: X => Y         = x => f(x).negate
