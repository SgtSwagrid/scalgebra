package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions form an [[AdditiveMonoid]] under
  * pointwise addition, provided the return type has an [[AdditiveMonoid]]
  * instance.
  */
trait FunctionIsAdditiveMonoid:

  given [X, Y : AdditiveMonoid as Y]: AdditiveMonoid[X => Y] with

    override def zero: X => Y = _ => Y.zero

    override inline def add(f: X => Y, g: X => Y): X => Y =
      x => Y.add(f(x), g(x))
