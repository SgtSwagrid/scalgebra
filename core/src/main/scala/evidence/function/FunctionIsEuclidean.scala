package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions form a [[Euclidean]] under pointwise
  * division, provided the return type has a [[Euclidean]] instance.
  */
trait FunctionIsEuclidean:

  given [X, Y : Euclidean as Y]: Euclidean[X => Y] with

    override inline def divide(f: X => Y, g: X => Y): X => Y =
      x => Y.divide(f(x), g(x))
