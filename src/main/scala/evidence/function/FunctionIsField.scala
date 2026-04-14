package io.github.sgtswagrid.structures
package evidence.function

/**
  * Evidence that single-argument functions form a [[Field]] under pointwise
  * addition, negation, multiplication, division, and reciprocation, provided
  * the return type has a [[Field]] instance.
  */
trait FunctionIsField:

  given [X, Y : Field as Y]: Field[X => Y] with

    override def zero: X => Y = _ => Y.zero

    override def one: X => Y = _ => Y.one

    override inline def add(f: X => Y, g: X => Y): X => Y =
      x => Y.add(f(x), g(x))

    override inline def negate(f: X => Y): X => Y = x => Y.negate(f(x))

    override inline def multiply(f: X => Y, g: X => Y): X => Y =
      x => Y.multiply(f(x), g(x))

    override inline def reciprocate(f: X => Y): X => Y =
      x => Y.reciprocate(f(x))
