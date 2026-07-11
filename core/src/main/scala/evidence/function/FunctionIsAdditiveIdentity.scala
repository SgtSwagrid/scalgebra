package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.AdditiveIdentity

/**
  * Evidence that single-argument functions have an [[AdditiveIdentity]],
  * provided the return type has an [[AdditiveIdentity]] instance.
  *
  * The zero function maps every input to `zero`.
  */
trait FunctionIsAdditiveIdentity:

  given [X, Y : AdditiveIdentity as Y] => AdditiveIdentity[X => Y]:
    override def zero: X => Y = _ => Y.zero
