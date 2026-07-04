package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.QuotientSemigroup

/**
  * Evidence that tuples of any arity up to 6 form a [[QuotientSemigroup]] under
  * componentwise multiplication and division, provided all element types have
  * [[QuotientSemigroup]] instances.
  */
trait TupleIsQuotientSemigroup:

  given [X : QuotientSemigroup as X] => QuotientSemigroup[X *: EmptyTuple]:

    extension (x: X *: EmptyTuple)

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple

      override def div(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head / y.head) *: EmptyTuple

  given [
    X : QuotientSemigroup as X,
    Y : QuotientSemigroup as Y,
  ] => QuotientSemigroup[(X, Y)]:

    extension (x: (X, Y))

      override def mul(y: (X, Y)): (X, Y) = (x(0) * y(0), x(1) * y(1))
      override def div(y: (X, Y)): (X, Y) = (x(0) / y(0), x(1) / y(1))

  given [
    X : QuotientSemigroup as X,
    Y : QuotientSemigroup as Y,
    Z : QuotientSemigroup as Z,
  ] => QuotientSemigroup[(X, Y, Z)]:

    extension (x: (X, Y, Z))

      override def mul(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2))

      override def div(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2))

  given [
    X1 : QuotientSemigroup as X1,
    X2 : QuotientSemigroup as X2,
    X3 : QuotientSemigroup as X3,
    X4 : QuotientSemigroup as X4,
  ] => QuotientSemigroup[(X1, X2, X3, X4)]:

    extension (x: (X1, X2, X3, X4))

      override def mul(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3))

      override def div(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2), x(3) / y(3))

  given [
    X1 : QuotientSemigroup as X1,
    X2 : QuotientSemigroup as X2,
    X3 : QuotientSemigroup as X3,
    X4 : QuotientSemigroup as X4,
    X5 : QuotientSemigroup as X5,
  ] => QuotientSemigroup[(X1, X2, X3, X4, X5)]:

    extension (x: (X1, X2, X3, X4, X5))

      override def mul(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3), x(4) * y(4))

      override def div(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2), x(3) / y(3), x(4) / y(4))

  given [
    X1 : QuotientSemigroup as X1,
    X2 : QuotientSemigroup as X2,
    X3 : QuotientSemigroup as X3,
    X4 : QuotientSemigroup as X4,
    X5 : QuotientSemigroup as X5,
    X6 : QuotientSemigroup as X6,
  ] => QuotientSemigroup[(X1, X2, X3, X4, X5, X6)]:

    extension (x: (X1, X2, X3, X4, X5, X6))

      override def mul(y: (X1, X2, X3, X4, X5, X6)): (X1, X2, X3, X4, X5, X6) =
        (
          x(0) * y(0),
          x(1) * y(1),
          x(2) * y(2),
          x(3) * y(3),
          x(4) * y(4),
          x(5) * y(5),
        )

      override def div(y: (X1, X2, X3, X4, X5, X6)): (X1, X2, X3, X4, X5, X6) =
        (
          x(0) / y(0),
          x(1) / y(1),
          x(2) / y(2),
          x(3) / y(3),
          x(4) / y(4),
          x(5) / y(5),
        )
