package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions form an [[AdditiveGroup]] under
  * pointwise negation and addition, provided the return type has an
  * [[AdditiveGroup]] instance.
  */
trait FunctionIsAdditiveGroup:

  given [X, Y : AdditiveGroup as Y]: AdditiveGroup[X => Y] with

    override def zero: X => Y = _ => Y.zero

    override inline def add(f: X => Y, g: X => Y): X => Y =
      x => Y.add(f(x), g(x))

    override inline def negate(f: X => Y): X => Y = x => Y.negate(f(x))
