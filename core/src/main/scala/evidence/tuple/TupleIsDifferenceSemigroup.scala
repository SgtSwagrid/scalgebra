package com.alecdorrington.scalgebra
package evidence.tuple

/**
  * Evidence that tuples of any arity up to 6 form a [[DifferenceSemigroup]]
  * under componentwise addition and subtraction, provided all element types
  * have [[DifferenceSemigroup]] instances.
  */
trait TupleIsDifferenceSemigroup:

  given [X : DifferenceSemigroup as X]: DifferenceSemigroup[X *: EmptyTuple]
  with

    override inline def add
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.add(x.head, y.head) *: EmptyTuple

    override inline def subtract
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.subtract(x.head, y.head) *: EmptyTuple

  given [
    X : DifferenceSemigroup as X,
    Y : DifferenceSemigroup as Y,
  ]: DifferenceSemigroup[(X, Y)] with

    override inline def add(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.add(x(0), y(0)), Y.add(x(1), y(1)))

    override inline def subtract(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.subtract(x(0), y(0)), Y.subtract(x(1), y(1)))

  given [
    X : DifferenceSemigroup as X,
    Y : DifferenceSemigroup as Y,
    Z : DifferenceSemigroup as Z,
  ]: DifferenceSemigroup[(X, Y, Z)] with

    override inline def add(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.add(x(0), y(0)), Y.add(x(1), y(1)), Z.add(x(2), y(2)))

    override inline def subtract(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.subtract(x(0), y(0)), Y.subtract(x(1), y(1)), Z.subtract(x(2), y(2)))

  given [
    X1 : DifferenceSemigroup as X1,
    X2 : DifferenceSemigroup as X2,
    X3 : DifferenceSemigroup as X3,
    X4 : DifferenceSemigroup as X4,
  ]: DifferenceSemigroup[(X1, X2, X3, X4)] with

    override inline def add
      (x: (X1, X2, X3, X4), y: (X1, X2, X3, X4))
      : (X1, X2, X3, X4) = (
      X1.add(x(0), y(0)),
      X2.add(x(1), y(1)),
      X3.add(x(2), y(2)),
      X4.add(x(3), y(3)),
    )

    override inline def subtract
      (x: (X1, X2, X3, X4), y: (X1, X2, X3, X4))
      : (X1, X2, X3, X4) = (
      X1.subtract(x(0), y(0)),
      X2.subtract(x(1), y(1)),
      X3.subtract(x(2), y(2)),
      X4.subtract(x(3), y(3)),
    )

  given [
    X1 : DifferenceSemigroup as X1,
    X2 : DifferenceSemigroup as X2,
    X3 : DifferenceSemigroup as X3,
    X4 : DifferenceSemigroup as X4,
    X5 : DifferenceSemigroup as X5,
  ]: DifferenceSemigroup[(X1, X2, X3, X4, X5)] with

    override inline def add
      (x: (X1, X2, X3, X4, X5), y: (X1, X2, X3, X4, X5))
      : (X1, X2, X3, X4, X5) = (
      X1.add(x(0), y(0)),
      X2.add(x(1), y(1)),
      X3.add(x(2), y(2)),
      X4.add(x(3), y(3)),
      X5.add(x(4), y(4)),
    )

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
    X1 : DifferenceSemigroup as X1,
    X2 : DifferenceSemigroup as X2,
    X3 : DifferenceSemigroup as X3,
    X4 : DifferenceSemigroup as X4,
    X5 : DifferenceSemigroup as X5,
    X6 : DifferenceSemigroup as X6,
  ]: DifferenceSemigroup[(X1, X2, X3, X4, X5, X6)] with

    override inline def add
      (
        x: (X1, X2, X3, X4, X5, X6),
        y: (X1, X2, X3, X4, X5, X6),
      )
      : (X1, X2, X3, X4, X5, X6) = (
      X1.add(x(0), y(0)),
      X2.add(x(1), y(1)),
      X3.add(x(2), y(2)),
      X4.add(x(3), y(3)),
      X5.add(x(4), y(4)),
      X6.add(x(5), y(5)),
    )

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
