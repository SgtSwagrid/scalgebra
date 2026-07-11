package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeSemigroup

/**
  * Evidence that tuples of any arity up to 6 form a [[MultiplicativeSemigroup]]
  * under componentwise multiplication, provided all element types have
  * [[MultiplicativeSemigroup]] instances.
  */
trait TupleIsMultiplicativeSemigroup:

  given [X : MultiplicativeSemigroup as X]
    => MultiplicativeSemigroup[X *: EmptyTuple]:

    extension (x: X *: EmptyTuple)

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple

  given [
    X : MultiplicativeSemigroup as X,
    Y : MultiplicativeSemigroup as Y,
  ] => MultiplicativeSemigroup[(X, Y)]:

    extension (x: (X, Y))
      override def mul(y: (X, Y)): (X, Y) = (x(0) * y(0), x(1) * y(1))

  given [
    X : MultiplicativeSemigroup as X,
    Y : MultiplicativeSemigroup as Y,
    Z : MultiplicativeSemigroup as Z,
  ] => MultiplicativeSemigroup[(X, Y, Z)]:

    extension (x: (X, Y, Z))

      override def mul(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2))

  given [
    X1 : MultiplicativeSemigroup as X1,
    X2 : MultiplicativeSemigroup as X2,
    X3 : MultiplicativeSemigroup as X3,
    X4 : MultiplicativeSemigroup as X4,
  ] => MultiplicativeSemigroup[(X1, X2, X3, X4)]:

    extension (x: (X1, X2, X3, X4))

      override def mul(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3))

  given [
    X1 : MultiplicativeSemigroup as X1,
    X2 : MultiplicativeSemigroup as X2,
    X3 : MultiplicativeSemigroup as X3,
    X4 : MultiplicativeSemigroup as X4,
    X5 : MultiplicativeSemigroup as X5,
  ] => MultiplicativeSemigroup[(X1, X2, X3, X4, X5)]:

    extension (x: (X1, X2, X3, X4, X5))

      override def mul(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3), x(4) * y(4))

  given [
    X1 : MultiplicativeSemigroup as X1,
    X2 : MultiplicativeSemigroup as X2,
    X3 : MultiplicativeSemigroup as X3,
    X4 : MultiplicativeSemigroup as X4,
    X5 : MultiplicativeSemigroup as X5,
    X6 : MultiplicativeSemigroup as X6,
  ] => MultiplicativeSemigroup[(X1, X2, X3, X4, X5, X6)]:

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
