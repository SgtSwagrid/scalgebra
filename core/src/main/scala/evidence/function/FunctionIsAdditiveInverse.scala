package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.AdditiveInverse

/**
  * Evidence that single-argument functions have an [[AdditiveInverse]] under
  * pointwise negation, provided the return type has an [[AdditiveInverse]]
  * instance.
  */
trait FunctionIsAdditiveInverse:

  given [X, Y : AdditiveInverse as Y] => AdditiveInverse[X => Y]:
    extension (f: X => Y) override def negate: X => Y = x => f(x).negate
