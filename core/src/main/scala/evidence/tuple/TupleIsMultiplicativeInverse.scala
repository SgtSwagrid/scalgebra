package com.alecdorrington.scalgebra
package evidence.tuple

/**
  * Evidence that tuples of arity 0 and 1 have a [[MultiplicativeInverse]] under
  * componentwise reciprocation, provided the element type (if any) has a
  * [[MultiplicativeInverse]] instance.
  */
trait TupleIsMultiplicativeInverse:

  given [X : MultiplicativeInverse as X]: MultiplicativeInverse[X *: EmptyTuple]
  with

    override inline def reciprocate(x: X *: EmptyTuple): X *: EmptyTuple = X
      .reciprocate(x.head) *: EmptyTuple
