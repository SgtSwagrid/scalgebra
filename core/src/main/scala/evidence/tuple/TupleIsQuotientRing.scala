package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.QuotientRing

/**
  * Evidence that tuples of any arity up to 6 form a [[QuotientRing]] under
  * componentwise addition, negation, multiplication, and division, provided all
  * element types have [[QuotientRing]] instances.
  */
trait TupleIsQuotientRing:

  given [X : QuotientRing as X] => QuotientRing[X *: EmptyTuple]:

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple
    override def one: X *: EmptyTuple  = X.one *: EmptyTuple

    extension (x: X *: EmptyTuple)

      override def add(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head + y.head) *: EmptyTuple

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple
      override def negate: X *: EmptyTuple = x.head.negate *: EmptyTuple

      override def div(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head / y.head) *: EmptyTuple

  given [X : QuotientRing as X, Y : QuotientRing as Y] => QuotientRing[(X, Y)]:

    override def zero: (X, Y) = (X.zero, Y.zero)
    override def one: (X, Y)  = (X.one, Y.one)

    extension (x: (X, Y))

      override def add(y: (X, Y)): (X, Y) = (x(0) + y(0), x(1) + y(1))
      override def mul(y: (X, Y)): (X, Y) = (x(0) * y(0), x(1) * y(1))
      override def negate: (X, Y)         = (x(0).negate, x(1).negate)
      override def div(y: (X, Y)): (X, Y) = (x(0) / y(0), x(1) / y(1))

  given [
    X : QuotientRing as X,
    Y : QuotientRing as Y,
    Z : QuotientRing as Z,
  ] => QuotientRing[(X, Y, Z)]:

    override def zero: (X, Y, Z) = (X.zero, Y.zero, Z.zero)
    override def one: (X, Y, Z)  = (X.one, Y.one, Z.one)

    extension (x: (X, Y, Z))

      override def add(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2))

      override def mul(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2))
      override def negate: (X, Y, Z) = (x(0).negate, x(1).negate, x(2).negate)

      override def div(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2))

  given [
    X1 : QuotientRing as X1,
    X2 : QuotientRing as X2,
    X3 : QuotientRing as X3,
    X4 : QuotientRing as X4,
  ] => QuotientRing[(X1, X2, X3, X4)]:

    override def zero: (X1, X2, X3, X4) = (X1.zero, X2.zero, X3.zero, X4.zero)
    override def one: (X1, X2, X3, X4)  = (X1.one, X2.one, X3.one, X4.one)

    extension (x: (X1, X2, X3, X4))

      override def add(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3))

      override def mul(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3))

      override def negate: (X1, X2, X3, X4) =
        (x(0).negate, x(1).negate, x(2).negate, x(3).negate)

      override def div(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2), x(3) / y(3))

  given [
    X1 : QuotientRing as X1,
    X2 : QuotientRing as X2,
    X3 : QuotientRing as X3,
    X4 : QuotientRing as X4,
    X5 : QuotientRing as X5,
  ] => QuotientRing[(X1, X2, X3, X4, X5)]:

    override def zero: (X1, X2, X3, X4, X5) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero)

    override def one: (X1, X2, X3, X4, X5) =
      (X1.one, X2.one, X3.one, X4.one, X5.one)

    extension (x: (X1, X2, X3, X4, X5))

      override def add(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3), x(4) + y(4))

      override def mul(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3), x(4) * y(4))

      override def negate: (X1, X2, X3, X4, X5) =
        (x(0).negate, x(1).negate, x(2).negate, x(3).negate, x(4).negate)

      override def div(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2), x(3) / y(3), x(4) / y(4))

  given [
    X1 : QuotientRing as X1,
    X2 : QuotientRing as X2,
    X3 : QuotientRing as X3,
    X4 : QuotientRing as X4,
    X5 : QuotientRing as X5,
    X6 : QuotientRing as X6,
  ] => QuotientRing[(X1, X2, X3, X4, X5, X6)]:

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

      override def negate: (X1, X2, X3, X4, X5, X6) = (
        x(0).negate,
        x(1).negate,
        x(2).negate,
        x(3).negate,
        x(4).negate,
        x(5).negate,
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
