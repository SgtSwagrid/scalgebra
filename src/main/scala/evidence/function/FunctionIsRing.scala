package io.github.sgtswagrid.structures
package evidence.function

/**
  * Evidence that single-argument functions form a [[Ring]] under pointwise
  * negation, addition, and multiplication, provided the return type has a
  * [[Ring]] instance.
  */
trait FunctionIsRing:

  given [X, Y : Ring as Y]: Ring[X => Y] with

    override def zero: X => Y = _ => Y.zero

    override def one: X => Y = _ => Y.one

    override inline def add(f: X => Y, g: X => Y): X => Y =
      x => Y.add(f(x), g(x))

    override inline def multiply(f: X => Y, g: X => Y): X => Y =
      x => Y.multiply(f(x), g(x))

    override inline def negate(f: X => Y): X => Y = x => Y.negate(f(x))
