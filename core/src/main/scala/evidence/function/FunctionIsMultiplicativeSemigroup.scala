package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions form a [[MultiplicativeSemigroup]]
  * under pointwise multiplication, provided the return type has a
  * [[MultiplicativeSemigroup]] instance.
  */
trait FunctionIsMultiplicativeSemigroup:

  given [X, Y : MultiplicativeSemigroup as Y]: MultiplicativeSemigroup[X => Y]
  with

    override inline def multiply(f: X => Y, g: X => Y): X => Y =
      x => Y.multiply(f(x), g(x))
