package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.Pseudoring

/**
  * Evidence that tuples of any arity up to 6 form a [[Pseudoring]] under
  * componentwise negation, addition, and multiplication, provided all element
  * types have [[Pseudoring]] instances.
  */
trait TupleIsPseudoring:

  given [X : Pseudoring as X] => Pseudoring[X *: EmptyTuple]:

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple

    extension (x: X *: EmptyTuple)

      override def add(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head + y.head) *: EmptyTuple

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple
      override def negate: X *: EmptyTuple = x.head.negate *: EmptyTuple

  given [X : Pseudoring as X, Y : Pseudoring as Y] => Pseudoring[(X, Y)]:

    override def zero: (X, Y) = (X.zero, Y.zero)

    extension (x: (X, Y))

      override def add(y: (X, Y)): (X, Y) = (x(0) + y(0), x(1) + y(1))
      override def mul(y: (X, Y)): (X, Y) = (x(0) * y(0), x(1) * y(1))
      override def negate: (X, Y)         = (x(0).negate, x(1).negate)

  given [
    X : Pseudoring as X,
    Y : Pseudoring as Y,
    Z : Pseudoring as Z,
  ] => Pseudoring[(X, Y, Z)]:

    override def zero: (X, Y, Z) = (X.zero, Y.zero, Z.zero)

    extension (x: (X, Y, Z))

      override def add(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2))

      override def mul(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2))
      override def negate: (X, Y, Z) = (x(0).negate, x(1).negate, x(2).negate)

  given [
    X1 : Pseudoring as X1,
    X2 : Pseudoring as X2,
    X3 : Pseudoring as X3,
    X4 : Pseudoring as X4,
  ] => Pseudoring[(X1, X2, X3, X4)]:

    override def zero: (X1, X2, X3, X4) = (X1.zero, X2.zero, X3.zero, X4.zero)

    extension (x: (X1, X2, X3, X4))

      override def add(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3))

      override def mul(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3))

      override def negate: (X1, X2, X3, X4) =
        (x(0).negate, x(1).negate, x(2).negate, x(3).negate)

  given [
    X1 : Pseudoring as X1,
    X2 : Pseudoring as X2,
    X3 : Pseudoring as X3,
    X4 : Pseudoring as X4,
    X5 : Pseudoring as X5,
  ] => Pseudoring[(X1, X2, X3, X4, X5)]:

    override def zero: (X1, X2, X3, X4, X5) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero)

    extension (x: (X1, X2, X3, X4, X5))

      override def add(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3), x(4) + y(4))

      override def mul(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3), x(4) * y(4))

      override def negate: (X1, X2, X3, X4, X5) =
        (x(0).negate, x(1).negate, x(2).negate, x(3).negate, x(4).negate)

  given [
    X1 : Pseudoring as X1,
    X2 : Pseudoring as X2,
    X3 : Pseudoring as X3,
    X4 : Pseudoring as X4,
    X5 : Pseudoring as X5,
    X6 : Pseudoring as X6,
  ] => Pseudoring[(X1, X2, X3, X4, X5, X6)]:

    override def zero: (X1, X2, X3, X4, X5, X6) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero, X6.zero)

    extension (x: (X1, X2, X3, X4, X5, X6))

      override def add(y: (X1, X2, X3, X4, X5, X6)): (X1, X2, X3, X4, X5, X6) =
        (
          x(0) + y(0),
          x(1) + y(1),
          x(2) + y(2),
          x(3) + y(3),
          x(4) + y(4),
          x(5) + y(5),
        )

      override def mul(y: (X1, X2, X3, X4, X5, X6)): (X1, X2, X3, X4, X5, X6) =
        (
          x(0) * y(0),
          x(1) * y(1),
          x(2) * y(2),
          x(3) * y(3),
          x(4) * y(4),
          x(5) * y(5),
        )

      override def negate: (X1, X2, X3, X4, X5, X6) = (
        x(0).negate,
        x(1).negate,
        x(2).negate,
        x(3).negate,
        x(4).negate,
        x(5).negate,
      )
