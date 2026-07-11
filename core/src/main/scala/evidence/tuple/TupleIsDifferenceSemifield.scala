package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.DifferenceSemifield

/**
  * Evidence that tuples of arity 1 form a [[DifferenceSemifield]] under
  * componentwise addition, subtraction, multiplication, and reciprocation,
  * provided the element type (if any) has a [[DifferenceSemifield]] instance.
  */
trait TupleIsDifferenceSemifield:

  given [X : DifferenceSemifield as X] => DifferenceSemifield[X *: EmptyTuple]:

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple
    override def one: X *: EmptyTuple  = X.one *: EmptyTuple

    extension (x: X *: EmptyTuple)

      override def add(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head + y.head) *: EmptyTuple

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple

      override def subtract(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head - y.head) *: EmptyTuple
      override def reciprocal: X *: EmptyTuple = x.head.reciprocal *: EmptyTuple
