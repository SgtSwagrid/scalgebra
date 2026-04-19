package com.alecdorrington.scalgebra
package evidence.function

/**
  * Evidence that single-argument functions form a [[Semifield]] under pointwise
  * addition, multiplication, and reciprocation, provided the return type has a
  * [[Semifield]] instance.
  */
trait FunctionIsSemifield:

  given [X, Y : Semifield as Y]: Semifield[X => Y] with

    override def zero: X => Y = _ => Y.zero

    override def one: X => Y = _ => Y.one

    override inline def add(f: X => Y, g: X => Y): X => Y =
      x => Y.add(f(x), g(x))

    override inline def multiply(f: X => Y, g: X => Y): X => Y =
      x => Y.multiply(f(x), g(x))

    override inline def reciprocate(f: X => Y): X => Y =
      x => Y.reciprocate(f(x))
