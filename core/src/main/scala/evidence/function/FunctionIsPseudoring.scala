package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions form a [[Pseudoring]] under
  * pointwise negation, addition, and multiplication, provided the return type
  * has a [[Pseudoring]] instance.
  */
trait FunctionIsPseudoring:

  given [X, Y : Pseudoring as Y]: Pseudoring[X => Y] with

    override def zero: X => Y = _ => Y.zero

    override inline def add(f: X => Y, g: X => Y): X => Y =
      x => Y.add(f(x), g(x))

    override inline def multiply(f: X => Y, g: X => Y): X => Y =
      x => Y.multiply(f(x), g(x))

    override inline def negate(f: X => Y): X => Y = x => Y.negate(f(x))
