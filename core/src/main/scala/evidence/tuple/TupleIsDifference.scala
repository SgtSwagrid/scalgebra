package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.Difference

/**
  * Evidence that tuples of any arity up to 6 form a [[Difference]] under
  * componentwise subtraction, provided all element types have [[Difference]]
  * instances.
  */
trait TupleIsDifference:

  given [X : Difference as X] => Difference[X *: EmptyTuple]:

    extension (x: X *: EmptyTuple)

      override def subtract(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head - y.head) *: EmptyTuple

  given [X : Difference as X, Y : Difference as Y] => Difference[(X, Y)]:

    extension (x: (X, Y))
      override def subtract(y: (X, Y)): (X, Y) = (x(0) - y(0), x(1) - y(1))

  given [
    X : Difference as X,
    Y : Difference as Y,
    Z : Difference as Z,
  ] => Difference[(X, Y, Z)]:

    extension (x: (X, Y, Z))

      override def subtract(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) - y(0), x(1) - y(1), x(2) - y(2))

  given [
    X1 : Difference as X1,
    X2 : Difference as X2,
    X3 : Difference as X3,
    X4 : Difference as X4,
  ] => Difference[(X1, X2, X3, X4)]:

    extension (x: (X1, X2, X3, X4))

      override def subtract(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) - y(0), x(1) - y(1), x(2) - y(2), x(3) - y(3))

  given [
    X1 : Difference as X1,
    X2 : Difference as X2,
    X3 : Difference as X3,
    X4 : Difference as X4,
    X5 : Difference as X5,
  ] => Difference[(X1, X2, X3, X4, X5)]:

    extension (x: (X1, X2, X3, X4, X5))

      override def subtract(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) - y(0), x(1) - y(1), x(2) - y(2), x(3) - y(3), x(4) - y(4))

  given [
    X1 : Difference as X1,
    X2 : Difference as X2,
    X3 : Difference as X3,
    X4 : Difference as X4,
    X5 : Difference as X5,
    X6 : Difference as X6,
  ] => Difference[(X1, X2, X3, X4, X5, X6)]:

    extension (x: (X1, X2, X3, X4, X5, X6))

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
