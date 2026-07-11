package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeGroup

/**
  * Evidence that tuples of arity 1 form an [[OrderedMultiplicativeGroup]] under
  * componentwise reciprocation and multiplication and lexicographic ordering,
  * provided the element type (if any) has an [[OrderedMultiplicativeGroup]]
  * instance.
  */
trait TupleIsOrderedMultiplicativeGroup:

  given [X : OrderedMultiplicativeGroup as X]
    => OrderedMultiplicativeGroup[X *: EmptyTuple]:

    override def one: X *: EmptyTuple = X.one *: EmptyTuple

    override def compare(x: X *: EmptyTuple, y: X *: EmptyTuple): Int = X
      .compare(x.head, y.head)

    extension (x: X *: EmptyTuple)

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple

      override def reciprocal: X *: EmptyTuple = x.head.reciprocal *: EmptyTuple
