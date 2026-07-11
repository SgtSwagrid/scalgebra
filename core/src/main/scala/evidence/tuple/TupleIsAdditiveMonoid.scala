package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.AdditiveMonoid

/**
  * Evidence that tuples of any arity up to 6 form an [[AdditiveMonoid]] under
  * componentwise addition, provided all element types have [[AdditiveMonoid]]
  * instances.
  */
trait TupleIsAdditiveMonoid:

  given [X : AdditiveMonoid as X] => AdditiveMonoid[X *: EmptyTuple]:

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple

    extension (x: X *: EmptyTuple)

      override def add(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head + y.head) *: EmptyTuple

  given [
    X : AdditiveMonoid as X,
    Y : AdditiveMonoid as Y,
  ] => AdditiveMonoid[(X, Y)]:

    override def zero: (X, Y) = (X.zero, Y.zero)

    extension (x: (X, Y))
      override def add(y: (X, Y)): (X, Y) = (x(0) + y(0), x(1) + y(1))

  given [
    X : AdditiveMonoid as X,
    Y : AdditiveMonoid as Y,
    Z : AdditiveMonoid as Z,
  ] => AdditiveMonoid[(X, Y, Z)]:

    override def zero: (X, Y, Z) = (X.zero, Y.zero, Z.zero)

    extension (x: (X, Y, Z))

      override def add(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2))

  given [
    X1 : AdditiveMonoid as X1,
    X2 : AdditiveMonoid as X2,
    X3 : AdditiveMonoid as X3,
    X4 : AdditiveMonoid as X4,
  ] => AdditiveMonoid[(X1, X2, X3, X4)]:

    override def zero: (X1, X2, X3, X4) = (X1.zero, X2.zero, X3.zero, X4.zero)

    extension (x: (X1, X2, X3, X4))

      override def add(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3))

  given [
    X1 : AdditiveMonoid as X1,
    X2 : AdditiveMonoid as X2,
    X3 : AdditiveMonoid as X3,
    X4 : AdditiveMonoid as X4,
    X5 : AdditiveMonoid as X5,
  ] => AdditiveMonoid[(X1, X2, X3, X4, X5)]:

    override def zero: (X1, X2, X3, X4, X5) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero)

    extension (x: (X1, X2, X3, X4, X5))

      override def add(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) + y(0), x(1) + y(1), x(2) + y(2), x(3) + y(3), x(4) + y(4))

  given [
    X1 : AdditiveMonoid as X1,
    X2 : AdditiveMonoid as X2,
    X3 : AdditiveMonoid as X3,
    X4 : AdditiveMonoid as X4,
    X5 : AdditiveMonoid as X5,
    X6 : AdditiveMonoid as X6,
  ] => AdditiveMonoid[(X1, X2, X3, X4, X5, X6)]:

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
