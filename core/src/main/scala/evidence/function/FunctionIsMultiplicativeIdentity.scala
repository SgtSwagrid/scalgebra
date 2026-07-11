package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeIdentity

/**
  * Evidence that single-argument functions have a [[MultiplicativeIdentity]],
  * provided the return type has a [[MultiplicativeIdentity]] instance.
  *
  * The one function maps every input to `one`.
  */
trait FunctionIsMultiplicativeIdentity:

  given [X, Y : MultiplicativeIdentity as Y] => MultiplicativeIdentity[X => Y]:
    override def one: X => Y = _ => Y.one
