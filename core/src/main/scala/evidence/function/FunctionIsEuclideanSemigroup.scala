package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions form an [[EuclideanSemigroup]] under
  * pointwise multiplication and division, provided the return type has an
  * [[EuclideanSemigroup]] instance.
  */
trait FunctionIsEuclideanSemigroup:

  given [X, Y : EuclideanSemigroup as Y]: EuclideanSemigroup[X => Y] with

    override inline def multiply(f: X => Y, g: X => Y): X => Y =
      x => Y.multiply(f(x), g(x))

    override inline def divide(f: X => Y, g: X => Y): X => Y =
      x => Y.divide(f(x), g(x))
