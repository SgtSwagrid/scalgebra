package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions form a [[DifferenceSemifield]] under
  * pointwise addition, subtraction, multiplication, and reciprocation, provided
  * the return type has a [[DifferenceSemifield]] instance.
  */
trait FunctionIsDifferenceSemifield:

  given [X, Y : DifferenceSemifield as Y]: DifferenceSemifield[X => Y] with

    override def zero: X => Y = _ => Y.zero

    override def one: X => Y = _ => Y.one

    override inline def add(f: X => Y, g: X => Y): X => Y =
      x => Y.add(f(x), g(x))

    override inline def subtract(f: X => Y, g: X => Y): X => Y =
      x => Y.subtract(f(x), g(x))

    override inline def multiply(f: X => Y, g: X => Y): X => Y =
      x => Y.multiply(f(x), g(x))

    override inline def reciprocate(f: X => Y): X => Y =
      x => Y.reciprocate(f(x))
