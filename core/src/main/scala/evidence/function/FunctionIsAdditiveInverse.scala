package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions have an [[AdditiveInverse]] under
  * pointwise negation, provided the return type has an [[AdditiveInverse]]
  * instance.
  */
trait FunctionIsAdditiveInverse:

  given [X, Y : AdditiveInverse as Y]: AdditiveInverse[X => Y] with

    override inline def negate(f: X => Y): X => Y = x => Y.negate(f(x))
