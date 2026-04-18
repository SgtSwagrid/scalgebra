package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions form an [[EuclideanMonoid]] under
  * pointwise multiplication and division, provided the return type has an
  * [[EuclideanMonoid]] instance.
  */
trait FunctionIsEuclideanMonoid:

  given [X, Y : EuclideanMonoid as Y]: EuclideanMonoid[X => Y] with

    override def one: X => Y = _ => Y.one

    override inline def multiply(f: X => Y, g: X => Y): X => Y =
      x => Y.multiply(f(x), g(x))

    override inline def divide(f: X => Y, g: X => Y): X => Y =
      x => Y.divide(f(x), g(x))
