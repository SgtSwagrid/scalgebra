package io.github.sgtswagrid.structures
package evidence.function

/**
  * Evidence that single-argument functions have a [[MultiplicativeInverse]]
  * under pointwise reciprocation, provided the return type has a
  * [[MultiplicativeInverse]] instance.
  */
trait FunctionIsMultiplicativeInverse:

  given [X, Y : MultiplicativeInverse as Y]: MultiplicativeInverse[X => Y] with

    override inline def reciprocate(f: X => Y): X => Y =
      x => Y.reciprocate(f(x))
