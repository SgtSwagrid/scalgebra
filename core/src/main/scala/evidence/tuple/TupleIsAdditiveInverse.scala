package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.AdditiveInverse

/**
  * Evidence that tuples of any arity up to 6 have an [[AdditiveInverse]] under
  * componentwise negation, provided all element types have [[AdditiveInverse]]
  * instances.
  */
trait TupleIsAdditiveInverse:

  given [X : AdditiveInverse as X] => AdditiveInverse[X *: EmptyTuple]:

    extension (x: X *: EmptyTuple)
      override def negate: X *: EmptyTuple = x.head.negate *: EmptyTuple

  given [
    X : AdditiveInverse as X,
    Y : AdditiveInverse as Y,
  ] => AdditiveInverse[(X, Y)]:

    extension (x: (X, Y))
      override def negate: (X, Y) = (x(0).negate, x(1).negate)

  given [
    X : AdditiveInverse as X,
    Y : AdditiveInverse as Y,
    Z : AdditiveInverse as Z,
  ] => AdditiveInverse[(X, Y, Z)]:

    extension (x: (X, Y, Z))
      override def negate: (X, Y, Z) = (x(0).negate, x(1).negate, x(2).negate)

  given [
    X1 : AdditiveInverse as X1,
    X2 : AdditiveInverse as X2,
    X3 : AdditiveInverse as X3,
    X4 : AdditiveInverse as X4,
  ] => AdditiveInverse[(X1, X2, X3, X4)]:

    extension (x: (X1, X2, X3, X4))

      override def negate: (X1, X2, X3, X4) =
        (x(0).negate, x(1).negate, x(2).negate, x(3).negate)

  given [
    X1 : AdditiveInverse as X1,
    X2 : AdditiveInverse as X2,
    X3 : AdditiveInverse as X3,
    X4 : AdditiveInverse as X4,
    X5 : AdditiveInverse as X5,
  ] => AdditiveInverse[(X1, X2, X3, X4, X5)]:

    extension (x: (X1, X2, X3, X4, X5))

      override def negate: (X1, X2, X3, X4, X5) =
        (x(0).negate, x(1).negate, x(2).negate, x(3).negate, x(4).negate)

  given [
    X1 : AdditiveInverse as X1,
    X2 : AdditiveInverse as X2,
    X3 : AdditiveInverse as X3,
    X4 : AdditiveInverse as X4,
    X5 : AdditiveInverse as X5,
    X6 : AdditiveInverse as X6,
  ] => AdditiveInverse[(X1, X2, X3, X4, X5, X6)]:

    extension (x: (X1, X2, X3, X4, X5, X6))

      override def negate: (X1, X2, X3, X4, X5, X6) = (
        x(0).negate,
        x(1).negate,
        x(2).negate,
        x(3).negate,
        x(4).negate,
        x(5).negate,
      )
