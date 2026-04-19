package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeInverse

/**
  * Evidence that tuples of arity 0 and 1 have an
  * [[OrderedMultiplicativeInverse]] under componentwise reciprocation and
  * lexicographic ordering, provided the element type (if any) has an
  * [[OrderedMultiplicativeInverse]] instance.
  */
trait TupleIsOrderedMultiplicativeInverse:

  given [X : OrderedMultiplicativeInverse as X]
    : OrderedMultiplicativeInverse[X *: EmptyTuple] with

    override inline def reciprocate(x: X *: EmptyTuple): X *: EmptyTuple = X
      .reciprocate(x.head) *: EmptyTuple

    override inline def compare(x: X *: EmptyTuple, y: X *: EmptyTuple): Int = X
      .compare(x.head, y.head)
