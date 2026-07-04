package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.Semifield

/**
  * Evidence that tuples of arity 1 form a [[Semifield]] under componentwise
  * addition, multiplication, and reciprocation, provided the element type (if
  * any) has a [[Semifield]] instance.
  */
trait TupleIsSemifield:

  given [X : Semifield as X] => Semifield[X *: EmptyTuple]:

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple
    override def one: X *: EmptyTuple  = X.one *: EmptyTuple

    extension (x: X *: EmptyTuple)

      override def add(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head + y.head) *: EmptyTuple

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple
      override def reciprocal: X *: EmptyTuple = x.head.reciprocal *: EmptyTuple
