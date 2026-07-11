package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.QuotientSemiring

/**
  * Evidence that tuples of any arity up to 6 form a [[QuotientSemiring]] under
  * componentwise addition, multiplication, and division, provided all element
  * types have [[QuotientSemiring]] instances.
  */
trait TupleIsQuotientSemiring:

  given [X : QuotientSemiring as X] => QuotientSemiring[X *: EmptyTuple]:

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple
    override def one: X *: EmptyTuple  = X.one *: EmptyTuple

    extension (x: X *: EmptyTuple)

      override def add(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head + y.head) *: EmptyTuple

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple

      override def div(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head / y.head) *: EmptyTuple

  given [
    X : QuotientSemiring as X,
    Y : QuotientSemiring as Y,
  ] => QuotientSemiring[(X, Y)]:

    override def zero: (X, Y) = (X.zero, Y.zero)
    override def one: (X, Y)  = (X.one, Y.one)

    extension (x: (X, Y))

      override def add(y: (X, Y)): (X, Y) = (x(0) + y(0), x(1) + y(1))
      override def mul(y: (X, Y)): (X, Y) = (x(0) * y(0), x(1) * y(1))
      override def div(y: (X, Y)): (X, Y) = (x(0) / y(0), x(1) / y(1))

  given [
    X : QuotientSemiring as X,
    Y : QuotientSemiring as Y,
    Z : QuotientSemiring as Z,
  ] => QuotientSemiring[(X, Y, Z)]:

    override def zero: (X, Y, Z) = (X.zero, Y.zero, Z.zero)
    override def one: (X, Y, Z)  = (X.one, Y.one, Z.one)

    extension (x: (X, Y, Z))

      override def add(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2))

      override def mul(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2))

      override def div(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2))

  given [
    X1 : QuotientSemiring as X1,
    X2 : QuotientSemiring as X2,
    X3 : QuotientSemiring as X3,
    X4 : QuotientSemiring as X4,
  ] => QuotientSemiring[(X1, X2, X3, X4)]:

    override def zero: (X1, X2, X3, X4) = (X1.zero, X2.zero, X3.zero, X4.zero)
    override def one: (X1, X2, X3, X4)  = (X1.one, X2.one, X3.one, X4.one)

    extension (x: (X1, X2, X3, X4))

      override def add(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3))

      override def mul(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3))

      override def div(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2), x(3) / y(3))

  given [
    X1 : QuotientSemiring as X1,
    X2 : QuotientSemiring as X2,
    X3 : QuotientSemiring as X3,
    X4 : QuotientSemiring as X4,
    X5 : QuotientSemiring as X5,
  ] => QuotientSemiring[(X1, X2, X3, X4, X5)]:

    override def zero: (X1, X2, X3, X4, X5) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero)

    override def one: (X1, X2, X3, X4, X5) =
      (X1.one, X2.one, X3.one, X4.one, X5.one)

    extension (x: (X1, X2, X3, X4, X5))

      override def add(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3), x(4) + y(4))

      override def mul(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3), x(4) * y(4))

      override def div(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2), x(3) / y(3), x(4) / y(4))

  given [
    X1 : QuotientSemiring as X1,
    X2 : QuotientSemiring as X2,
    X3 : QuotientSemiring as X3,
    X4 : QuotientSemiring as X4,
    X5 : QuotientSemiring as X5,
    X6 : QuotientSemiring as X6,
  ] => QuotientSemiring[(X1, X2, X3, X4, X5, X6)]:

    override def zero: (X1, X2, X3, X4, X5, X6) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero, X6.zero)

    override def one: (X1, X2, X3, X4, X5, X6) =
      (X1.one, X2.one, X3.one, X4.one, X5.one, X6.one)

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

      override def div(y: (X1, X2, X3, X4, X5, X6)): (X1, X2, X3, X4, X5, X6) =
        (
          x(0) / y(0),
          x(1) / y(1),
          x(2) / y(2),
          x(3) / y(3),
          x(4) / y(4),
          x(5) / y(5),
        )
