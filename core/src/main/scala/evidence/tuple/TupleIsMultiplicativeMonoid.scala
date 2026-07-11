package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeMonoid

/**
  * Evidence that tuples of any arity up to 6 form a [[MultiplicativeMonoid]]
  * under componentwise multiplication, provided all element types have
  * [[MultiplicativeMonoid]] instances.
  */
trait TupleIsMultiplicativeMonoid:

  given [X : MultiplicativeMonoid as X]
    => MultiplicativeMonoid[X *: EmptyTuple]:

    override def one: X *: EmptyTuple = X.one *: EmptyTuple

    extension (x: X *: EmptyTuple)

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple

  given [
    X : MultiplicativeMonoid as X,
    Y : MultiplicativeMonoid as Y,
  ] => MultiplicativeMonoid[(X, Y)]:

    override def one: (X, Y) = (X.one, Y.one)

    extension (x: (X, Y))
      override def mul(y: (X, Y)): (X, Y) = (x(0) * y(0), x(1) * y(1))

  given [
    X : MultiplicativeMonoid as X,
    Y : MultiplicativeMonoid as Y,
    Z : MultiplicativeMonoid as Z,
  ] => MultiplicativeMonoid[(X, Y, Z)]:

    override def one: (X, Y, Z) = (X.one, Y.one, Z.one)

    extension (x: (X, Y, Z))

      override def mul(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2))

  given [
    X1 : MultiplicativeMonoid as X1,
    X2 : MultiplicativeMonoid as X2,
    X3 : MultiplicativeMonoid as X3,
    X4 : MultiplicativeMonoid as X4,
  ] => MultiplicativeMonoid[(X1, X2, X3, X4)]:

    override def one: (X1, X2, X3, X4) = (X1.one, X2.one, X3.one, X4.one)

    extension (x: (X1, X2, X3, X4))

      override def mul(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3))

  given [
    X1 : MultiplicativeMonoid as X1,
    X2 : MultiplicativeMonoid as X2,
    X3 : MultiplicativeMonoid as X3,
    X4 : MultiplicativeMonoid as X4,
    X5 : MultiplicativeMonoid as X5,
  ] => MultiplicativeMonoid[(X1, X2, X3, X4, X5)]:

    override def one: (X1, X2, X3, X4, X5) =
      (X1.one, X2.one, X3.one, X4.one, X5.one)

    extension (x: (X1, X2, X3, X4, X5))

      override def mul(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3), x(4) * y(4))

  given [
    X1 : MultiplicativeMonoid as X1,
    X2 : MultiplicativeMonoid as X2,
    X3 : MultiplicativeMonoid as X3,
    X4 : MultiplicativeMonoid as X4,
    X5 : MultiplicativeMonoid as X5,
    X6 : MultiplicativeMonoid as X6,
  ] => MultiplicativeMonoid[(X1, X2, X3, X4, X5, X6)]:

    override def one: (X1, X2, X3, X4, X5, X6) =
      (X1.one, X2.one, X3.one, X4.one, X5.one, X6.one)

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
