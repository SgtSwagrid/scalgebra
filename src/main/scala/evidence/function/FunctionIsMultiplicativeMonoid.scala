package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions form a [[MultiplicativeMonoid]]
  * under pointwise multiplication, provided the return type has a
  * [[MultiplicativeMonoid]] instance.
  */
trait FunctionIsMultiplicativeMonoid:

  given [X, Y : MultiplicativeMonoid as Y]: MultiplicativeMonoid[X => Y] with

    override def one: X => Y = _ => Y.one

    override inline def multiply(f: X => Y, g: X => Y): X => Y =
      x => Y.multiply(f(x), g(x))
