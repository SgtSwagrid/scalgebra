package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemifield

/**
  * Evidence that tuples of arity 1 form an [[OrderedDifferenceSemifield]] under
  * componentwise addition, subtraction, multiplication, and reciprocation and
  * lexicographic ordering, provided the element type (if any) has an
  * [[OrderedDifferenceSemifield]] instance.
  */
trait TupleIsOrderedDifferenceSemifield:

  given [X : OrderedDifferenceSemifield as X]
    => OrderedDifferenceSemifield[X *: EmptyTuple]:

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple
    override def one: X *: EmptyTuple  = X.one *: EmptyTuple

    override def compare(x: X *: EmptyTuple, y: X *: EmptyTuple): Int = X
      .compare(x.head, y.head)

    extension (x: X *: EmptyTuple)

      override def add(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head + y.head) *: EmptyTuple

      override def subtract(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head - y.head) *: EmptyTuple

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple

      override def reciprocal: X *: EmptyTuple = x.head.reciprocal *: EmptyTuple
