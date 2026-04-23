package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions form a [[DifferenceSemigroup]] under
  * pointwise addition and subtraction, provided the return type has a
  * [[DifferenceSemigroup]] instance.
  */
trait FunctionIsDifferenceSemigroup:

  given [X, Y : DifferenceSemigroup as Y]: DifferenceSemigroup[X => Y] with

    override inline def add(f: X => Y, g: X => Y): X => Y =
      x => Y.add(f(x), g(x))

    override inline def subtract(f: X => Y, g: X => Y): X => Y =
      x => Y.subtract(f(x), g(x))
