package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.AdditiveSemigroup

/**
  * Evidence that tuples of any arity up to 6 form an [[AdditiveSemigroup]]
  * under componentwise addition, provided all element types have
  * [[AdditiveSemigroup]] instances.
  */
trait TupleIsAdditiveSemigroup:

  given [X : AdditiveSemigroup as X] => AdditiveSemigroup[X *: EmptyTuple]:

    extension (x: X *: EmptyTuple)

      override def add(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head + y.head) *: EmptyTuple

  given [
    X : AdditiveSemigroup as X,
    Y : AdditiveSemigroup as Y,
  ] => AdditiveSemigroup[(X, Y)]:

    extension (x: (X, Y))
      override def add(y: (X, Y)): (X, Y) = (x(0) + y(0), x(1) + y(1))

  given [
    X : AdditiveSemigroup as X,
    Y : AdditiveSemigroup as Y,
    Z : AdditiveSemigroup as Z,
  ] => AdditiveSemigroup[(X, Y, Z)]:

    extension (x: (X, Y, Z))

      override def add(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2))

  given [
    X1 : AdditiveSemigroup as X1,
    X2 : AdditiveSemigroup as X2,
    X3 : AdditiveSemigroup as X3,
    X4 : AdditiveSemigroup as X4,
  ] => AdditiveSemigroup[(X1, X2, X3, X4)]:

    extension (x: (X1, X2, X3, X4))

      override def add(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3))

  given [
    X1 : AdditiveSemigroup as X1,
    X2 : AdditiveSemigroup as X2,
    X3 : AdditiveSemigroup as X3,
    X4 : AdditiveSemigroup as X4,
    X5 : AdditiveSemigroup as X5,
  ] => AdditiveSemigroup[(X1, X2, X3, X4, X5)]:

    extension (x: (X1, X2, X3, X4, X5))

      override def add(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3), x(4) + y(4))

  given [
    X1 : AdditiveSemigroup as X1,
    X2 : AdditiveSemigroup as X2,
    X3 : AdditiveSemigroup as X3,
    X4 : AdditiveSemigroup as X4,
    X5 : AdditiveSemigroup as X5,
    X6 : AdditiveSemigroup as X6,
  ] => AdditiveSemigroup[(X1, X2, X3, X4, X5, X6)]:

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
