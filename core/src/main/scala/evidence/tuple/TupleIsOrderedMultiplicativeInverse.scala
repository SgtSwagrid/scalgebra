package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeInverse

/**
  * Evidence that tuples of arity 1 have an [[OrderedMultiplicativeInverse]]
  * under componentwise reciprocation and lexicographic ordering, provided the
  * element type (if any) has an [[OrderedMultiplicativeInverse]] instance.
  */
trait TupleIsOrderedMultiplicativeInverse:

  given [X : OrderedMultiplicativeInverse as X]
    => OrderedMultiplicativeInverse[X *: EmptyTuple]:

    override def compare(x: X *: EmptyTuple, y: X *: EmptyTuple): Int = X
      .compare(x.head, y.head)

    extension (x: X *: EmptyTuple)

      override def reciprocal: X *: EmptyTuple = x.head.reciprocal *: EmptyTuple
