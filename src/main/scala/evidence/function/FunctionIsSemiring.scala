package io.github.sgtswagrid.structures
package evidence.function

/**
  * Evidence that single-argument functions form a [[Semiring]] under pointwise
  * addition and multiplication, provided the return type has a [[Semiring]]
  * instance.
  */
trait FunctionIsSemiring:

  given [X, Y : Semiring as Y]: Semiring[X => Y] with

    override def zero: X => Y = _ => Y.zero

    override def one: X => Y = _ => Y.one

    override inline def add(f: X => Y, g: X => Y): X => Y =
      x => Y.add(f(x), g(x))

    override inline def multiply(f: X => Y, g: X => Y): X => Y =
      x => Y.multiply(f(x), g(x))
