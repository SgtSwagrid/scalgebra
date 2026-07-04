package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeInverse

/**
  * Evidence that tuples of arity 1 have a [[MultiplicativeInverse]] under
  * componentwise reciprocation, provided the element type (if any) has a
  * [[MultiplicativeInverse]] instance.
  */
trait TupleIsMultiplicativeInverse:

  given [X : MultiplicativeInverse as X]
    => MultiplicativeInverse[X *: EmptyTuple]:

    extension (x: X *: EmptyTuple)
      override def reciprocal: X *: EmptyTuple = x.head.reciprocal *: EmptyTuple
