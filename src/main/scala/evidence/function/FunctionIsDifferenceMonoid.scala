package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions form a [[DifferenceMonoid]] under
  * pointwise addition and subtraction, provided the return type has a
  * [[DifferenceMonoid]] instance.
  */
trait FunctionIsDifferenceMonoid:

  given [X, Y : DifferenceMonoid as Y]: DifferenceMonoid[X => Y] with

    override def zero: X => Y = _ => Y.zero

    override inline def add(f: X => Y, g: X => Y): X => Y =
      x => Y.add(f(x), g(x))

    override inline def subtract(f: X => Y, g: X => Y): X => Y =
      x => Y.subtract(f(x), g(x))
