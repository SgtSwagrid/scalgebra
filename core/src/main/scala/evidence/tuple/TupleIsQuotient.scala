package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.Quotient

/**
  * Evidence that tuples of any arity up to 6 form a [[Quotient]] under
  * componentwise division, provided all element types have [[Quotient]]
  * instances.
  */
trait TupleIsQuotient:

  given [X : Quotient as X] => Quotient[X *: EmptyTuple]:

    extension (x: X *: EmptyTuple)

      override def div(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head / y.head) *: EmptyTuple

  given [X : Quotient as X, Y : Quotient as Y] => Quotient[(X, Y)]:

    extension (x: (X, Y))
      override def div(y: (X, Y)): (X, Y) = (x(0) / y(0), x(1) / y(1))

  given [
    X : Quotient as X,
    Y : Quotient as Y,
    Z : Quotient as Z,
  ] => Quotient[(X, Y, Z)]:

    extension (x: (X, Y, Z))

      override def div(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2))

  given [
    X1 : Quotient as X1,
    X2 : Quotient as X2,
    X3 : Quotient as X3,
    X4 : Quotient as X4,
  ] => Quotient[(X1, X2, X3, X4)]:

    extension (x: (X1, X2, X3, X4))

      override def div(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2), x(3) / y(3))

  given [
    X1 : Quotient as X1,
    X2 : Quotient as X2,
    X3 : Quotient as X3,
    X4 : Quotient as X4,
    X5 : Quotient as X5,
  ] => Quotient[(X1, X2, X3, X4, X5)]:

    extension (x: (X1, X2, X3, X4, X5))

      override def div(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2), x(3) / y(3), x(4) / y(4))

  given [
    X1 : Quotient as X1,
    X2 : Quotient as X2,
    X3 : Quotient as X3,
    X4 : Quotient as X4,
    X5 : Quotient as X5,
    X6 : Quotient as X6,
  ] => Quotient[(X1, X2, X3, X4, X5, X6)]:

    extension (x: (X1, X2, X3, X4, X5, X6))

      override def div(y: (X1, X2, X3, X4, X5, X6)): (X1, X2, X3, X4, X5, X6) =
        (
          x(0) / y(0),
          x(1) / y(1),
          x(2) / y(2),
          x(3) / y(3),
          x(4) / y(4),
          x(5) / y(5),
        )
