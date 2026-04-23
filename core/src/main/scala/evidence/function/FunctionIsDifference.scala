package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions form a [[Difference]] under
  * pointwise subtraction, provided the return type has a [[Difference]]
  * instance.
  */
trait FunctionIsDifference:

  given [X, Y : Difference as Y]: Difference[X => Y] with

    override inline def subtract(f: X => Y, g: X => Y): X => Y =
      x => Y.subtract(f(x), g(x))
