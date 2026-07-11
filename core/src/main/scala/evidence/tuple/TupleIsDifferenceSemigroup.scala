package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.DifferenceSemigroup

/**
  * Evidence that tuples of any arity up to 6 form a [[DifferenceSemigroup]]
  * under componentwise addition and subtraction, provided all element types
  * have [[DifferenceSemigroup]] instances.
  */
trait TupleIsDifferenceSemigroup:

  given [X : DifferenceSemigroup as X] => DifferenceSemigroup[X *: EmptyTuple]:

    extension (x: X *: EmptyTuple)

      override def add(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head + y.head) *: EmptyTuple

      override def subtract(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head - y.head) *: EmptyTuple

  given [
    X : DifferenceSemigroup as X,
    Y : DifferenceSemigroup as Y,
  ] => DifferenceSemigroup[(X, Y)]:

    extension (x: (X, Y))

      override def add(y: (X, Y)): (X, Y)      = (x(0) + y(0), x(1) + y(1))
      override def subtract(y: (X, Y)): (X, Y) = (x(0) - y(0), x(1) - y(1))

  given [
    X : DifferenceSemigroup as X,
    Y : DifferenceSemigroup as Y,
    Z : DifferenceSemigroup as Z,
  ] => DifferenceSemigroup[(X, Y, Z)]:

    extension (x: (X, Y, Z))

      override def add(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2))

      override def subtract(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) - y(0), x(1) - y(1), x(2) - y(2))

  given [
    X1 : DifferenceSemigroup as X1,
    X2 : DifferenceSemigroup as X2,
    X3 : DifferenceSemigroup as X3,
    X4 : DifferenceSemigroup as X4,
  ] => DifferenceSemigroup[(X1, X2, X3, X4)]:

    extension (x: (X1, X2, X3, X4))

      override def add(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3))

      override def subtract(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) - y(0), x(1) - y(1), x(2) - y(2), x(3) - y(3))

  given [
    X1 : DifferenceSemigroup as X1,
    X2 : DifferenceSemigroup as X2,
    X3 : DifferenceSemigroup as X3,
    X4 : DifferenceSemigroup as X4,
    X5 : DifferenceSemigroup as X5,
  ] => DifferenceSemigroup[(X1, X2, X3, X4, X5)]:

    extension (x: (X1, X2, X3, X4, X5))

      override def add(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3), x(4) + y(4))

      override def subtract(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) - y(0), x(1) - y(1), x(2) - y(2), x(3) - y(3), x(4) - y(4))

  given [
    X1 : DifferenceSemigroup as X1,
    X2 : DifferenceSemigroup as X2,
    X3 : DifferenceSemigroup as X3,
    X4 : DifferenceSemigroup as X4,
    X5 : DifferenceSemigroup as X5,
    X6 : DifferenceSemigroup as X6,
  ] => DifferenceSemigroup[(X1, X2, X3, X4, X5, X6)]:

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
