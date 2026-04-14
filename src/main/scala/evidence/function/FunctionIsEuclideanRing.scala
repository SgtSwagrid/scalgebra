package io.github.sgtswagrid.structures
package evidence.function

/**
  * Evidence that single-argument functions form an [[EuclideanRing]] under
  * pointwise addition, negation, multiplication, and division, provided the
  * return type has an [[EuclideanRing]] instance.
  */
trait FunctionIsEuclideanRing:

  given [X, Y : EuclideanRing as Y]: EuclideanRing[X => Y] with

    override def zero: X => Y = _ => Y.zero

    override def one: X => Y = _ => Y.one

    override inline def add(f: X => Y, g: X => Y): X => Y =
      x => Y.add(f(x), g(x))

    override inline def negate(f: X => Y): X => Y = x => Y.negate(f(x))

    override inline def multiply(f: X => Y, g: X => Y): X => Y =
      x => Y.multiply(f(x), g(x))

    override inline def divide(f: X => Y, g: X => Y): X => Y =
      x => Y.divide(f(x), g(x))
