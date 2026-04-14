package io.github.sgtswagrid.structures
package evidence.function

/**
  * Evidence that single-argument functions form an [[AdditiveSemigroup]] under
  * pointwise addition, provided the return type has an [[AdditiveSemigroup]]
  * instance.
  */
trait FunctionIsAdditiveSemigroup:

  given [X, Y : AdditiveSemigroup as Y]: AdditiveSemigroup[X => Y] with

    override inline def add(f: X => Y, g: X => Y): X => Y =
      x => Y.add(f(x), g(x))
