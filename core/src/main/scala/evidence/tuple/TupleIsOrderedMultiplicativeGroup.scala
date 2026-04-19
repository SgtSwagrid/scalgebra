package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeGroup

/**
  * Evidence that tuples of arity 0 and 1 form an [[OrderedMultiplicativeGroup]]
  * under componentwise reciprocation and multiplication and lexicographic
  * ordering, provided the element type (if any) has an
  * [[OrderedMultiplicativeGroup]] instance.
  */
trait TupleIsOrderedMultiplicativeGroup:

  given [X : OrderedMultiplicativeGroup as X]
    : OrderedMultiplicativeGroup[X *: EmptyTuple] with

    override def one: X *: EmptyTuple = X.one *: EmptyTuple

    override inline def multiply
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.multiply(x.head, y.head) *: EmptyTuple

    override inline def reciprocate(x: X *: EmptyTuple): X *: EmptyTuple = X
      .reciprocate(x.head) *: EmptyTuple

    override inline def compare(x: X *: EmptyTuple, y: X *: EmptyTuple): Int = X
      .compare(x.head, y.head)
