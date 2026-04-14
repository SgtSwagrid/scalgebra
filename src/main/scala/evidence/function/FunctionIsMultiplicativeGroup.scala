package io.github.sgtswagrid.structures
package evidence.function

/**
  * Evidence that single-argument functions form a [[MultiplicativeGroup]] under
  * pointwise reciprocation and multiplication, provided the return type has a
  * [[MultiplicativeGroup]] instance.
  */
trait FunctionIsMultiplicativeGroup:

  given [X, Y : MultiplicativeGroup as Y]: MultiplicativeGroup[X => Y] with

    override def one: X => Y = _ => Y.one

    override inline def multiply(f: X => Y, g: X => Y): X => Y =
      x => Y.multiply(f(x), g(x))

    override inline def reciprocate(f: X => Y): X => Y =
      x => Y.reciprocate(f(x))
