package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeInverse

/**
  * Evidence that single-argument functions have a [[MultiplicativeInverse]]
  * under pointwise reciprocation, provided the return type has a
  * [[MultiplicativeInverse]] instance.
  */
trait FunctionIsMultiplicativeInverse:

  given [X, Y : MultiplicativeInverse as Y] => MultiplicativeInverse[X => Y]:
    extension (f: X => Y) override def reciprocal: X => Y = x => f(x).reciprocal
