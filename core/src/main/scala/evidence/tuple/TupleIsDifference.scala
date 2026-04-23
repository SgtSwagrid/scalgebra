package com.alecdorrington.scalgebra
package evidence.tuple

/**
  * Evidence that tuples of any arity up to 6 form a [[Difference]] under
  * componentwise subtraction, provided all element types have [[Difference]]
  * instances.
  */
trait TupleIsDifference:

  given [X : Difference as X]: Difference[X *: EmptyTuple] with

    override inline def subtract
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.subtract(x.head, y.head) *: EmptyTuple

  given [X : Difference as X, Y : Difference as Y]: Difference[(X, Y)] with

    override inline def subtract(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.subtract(x(0), y(0)), Y.subtract(x(1), y(1)))

  given [
    X : Difference as X,
    Y : Difference as Y,
    Z : Difference as Z,
  ]: Difference[(X, Y, Z)] with

    override inline def subtract(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.subtract(x(0), y(0)), Y.subtract(x(1), y(1)), Z.subtract(x(2), y(2)))

  given [
    X1 : Difference as X1,
    X2 : Difference as X2,
    X3 : Difference as X3,
    X4 : Difference as X4,
  ]: Difference[(X1, X2, X3, X4)] with

    override inline def subtract
      (x: (X1, X2, X3, X4), y: (X1, X2, X3, X4))
      : (X1, X2, X3, X4) = (
      X1.subtract(x(0), y(0)),
      X2.subtract(x(1), y(1)),
      X3.subtract(x(2), y(2)),
      X4.subtract(x(3), y(3)),
    )

  given [
    X1 : Difference as X1,
    X2 : Difference as X2,
    X3 : Difference as X3,
    X4 : Difference as X4,
    X5 : Difference as X5,
  ]: Difference[(X1, X2, X3, X4, X5)] with

    override inline def subtract
      (x: (X1, X2, X3, X4, X5), y: (X1, X2, X3, X4, X5))
      : (X1, X2, X3, X4, X5) = (
      X1.subtract(x(0), y(0)),
      X2.subtract(x(1), y(1)),
      X3.subtract(x(2), y(2)),
      X4.subtract(x(3), y(3)),
      X5.subtract(x(4), y(4)),
    )

  given [
    X1 : Difference as X1,
    X2 : Difference as X2,
    X3 : Difference as X3,
    X4 : Difference as X4,
    X5 : Difference as X5,
    X6 : Difference as X6,
  ]: Difference[(X1, X2, X3, X4, X5, X6)] with

    override inline def subtract
      (
        x: (X1, X2, X3, X4, X5, X6),
        y: (X1, X2, X3, X4, X5, X6),
      )
      : (X1, X2, X3, X4, X5, X6) = (
      X1.subtract(x(0), y(0)),
      X2.subtract(x(1), y(1)),
      X3.subtract(x(2), y(2)),
      X4.subtract(x(3), y(3)),
      X5.subtract(x(4), y(4)),
      X6.subtract(x(5), y(5)),
    )
