package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.Field

/**
  * Evidence that tuples of arity 1 form a [[Field]] under componentwise
  * addition, negation, multiplication, and reciprocation, provided the element
  * type (if any) has a [[Field]] instance.
  */
trait TupleIsField:

  given [X : Field as X] => Field[X *: EmptyTuple]:

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple
    override def one: X *: EmptyTuple  = X.one *: EmptyTuple

    extension (x: X *: EmptyTuple)

      override def add(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head + y.head) *: EmptyTuple

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple
      override def negate: X *: EmptyTuple     = x.head.negate *: EmptyTuple
      override def reciprocal: X *: EmptyTuple = x.head.reciprocal *: EmptyTuple
