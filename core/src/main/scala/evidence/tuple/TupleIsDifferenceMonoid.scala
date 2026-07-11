package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.DifferenceMonoid

/**
  * Evidence that tuples of any arity up to 6 form a [[DifferenceMonoid]] under
  * componentwise addition and subtraction, provided all element types have
  * [[DifferenceMonoid]] instances.
  */
trait TupleIsDifferenceMonoid:

  given [X : DifferenceMonoid as X] => DifferenceMonoid[X *: EmptyTuple]:

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple

    extension (x: X *: EmptyTuple)

      override def add(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head + y.head) *: EmptyTuple

      override def subtract(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head - y.head) *: EmptyTuple

  given [
    X : DifferenceMonoid as X,
    Y : DifferenceMonoid as Y,
  ] => DifferenceMonoid[(X, Y)]:

    override def zero: (X, Y) = (X.zero, Y.zero)

    extension (x: (X, Y))

      override def add(y: (X, Y)): (X, Y)      = (x(0) + y(0), x(1) + y(1))
      override def subtract(y: (X, Y)): (X, Y) = (x(0) - y(0), x(1) - y(1))

  given [
    X : DifferenceMonoid as X,
    Y : DifferenceMonoid as Y,
    Z : DifferenceMonoid as Z,
  ] => DifferenceMonoid[(X, Y, Z)]:

    override def zero: (X, Y, Z) = (X.zero, Y.zero, Z.zero)

    extension (x: (X, Y, Z))

      override def add(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2))

      override def subtract(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) - y(0), x(1) - y(1), x(2) - y(2))

  given [
    X1 : DifferenceMonoid as X1,
    X2 : DifferenceMonoid as X2,
    X3 : DifferenceMonoid as X3,
    X4 : DifferenceMonoid as X4,
  ] => DifferenceMonoid[(X1, X2, X3, X4)]:

    override def zero: (X1, X2, X3, X4) = (X1.zero, X2.zero, X3.zero, X4.zero)

    extension (x: (X1, X2, X3, X4))

      override def add(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3))

      override def subtract(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) - y(0), x(1) - y(1), x(2) - y(2), x(3) - y(3))

  given [
    X1 : DifferenceMonoid as X1,
    X2 : DifferenceMonoid as X2,
    X3 : DifferenceMonoid as X3,
    X4 : DifferenceMonoid as X4,
    X5 : DifferenceMonoid as X5,
  ] => DifferenceMonoid[(X1, X2, X3, X4, X5)]:

    override def zero: (X1, X2, X3, X4, X5) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero)

    extension (x: (X1, X2, X3, X4, X5))

      override def add(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3), x(4) + y(4))

      override def subtract(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) - y(0), x(1) - y(1), x(2) - y(2), x(3) - y(3), x(4) - y(4))

  given [
    X1 : DifferenceMonoid as X1,
    X2 : DifferenceMonoid as X2,
    X3 : DifferenceMonoid as X3,
    X4 : DifferenceMonoid as X4,
    X5 : DifferenceMonoid as X5,
    X6 : DifferenceMonoid as X6,
  ] => DifferenceMonoid[(X1, X2, X3, X4, X5, X6)]:

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

      override def subtract
        (y: (X1, X2, X3, X4, X5, X6))
        : (X1, X2, X3, X4, X5, X6) = (
        x(0) - y(0),
        x(1) - y(1),
        x(2) - y(2),
        x(3) - y(3),
        x(4) - y(4),
        x(5) - y(5),
      )
