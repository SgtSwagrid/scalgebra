package io.github.sgtswagrid.structures
package evidence.function

/**
  * Evidence that single-argument functions have a [[MultiplicativeIdentity]],
  * provided the return type has a [[MultiplicativeIdentity]] instance.
  *
  * The one function maps every input to `one`.
  */
trait FunctionIsMultiplicativeIdentity:

  given [X, Y : MultiplicativeIdentity as Y]: MultiplicativeIdentity[X => Y]
  with

    override def one: X => Y = _ => Y.one
