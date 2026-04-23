package com.alecdorrington.scalgebra
package evidence.tuple

/**
  * Evidence that tuples of any arity up to 6 form a [[Euclidean]] under
  * componentwise division, provided all element types have [[Euclidean]]
  * instances.
  */
trait TupleIsEuclidean:

  given [X : Euclidean as X]: Euclidean[X *: EmptyTuple] with

    override inline def divide
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.divide(x.head, y.head) *: EmptyTuple

  given [X : Euclidean as X, Y : Euclidean as Y]: Euclidean[(X, Y)] with

    override inline def divide(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.divide(x(0), y(0)), Y.divide(x(1), y(1)))

  given [
    X : Euclidean as X,
    Y : Euclidean as Y,
    Z : Euclidean as Z,
  ]: Euclidean[(X, Y, Z)] with

    override inline def divide(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.divide(x(0), y(0)), Y.divide(x(1), y(1)), Z.divide(x(2), y(2)))

  given [
    X1 : Euclidean as X1,
    X2 : Euclidean as X2,
    X3 : Euclidean as X3,
    X4 : Euclidean as X4,
  ]: Euclidean[(X1, X2, X3, X4)] with

    override inline def divide
      (x: (X1, X2, X3, X4), y: (X1, X2, X3, X4))
      : (X1, X2, X3, X4) = (
      X1.divide(x(0), y(0)),
      X2.divide(x(1), y(1)),
      X3.divide(x(2), y(2)),
      X4.divide(x(3), y(3)),
    )

  given [
    X1 : Euclidean as X1,
    X2 : Euclidean as X2,
    X3 : Euclidean as X3,
    X4 : Euclidean as X4,
    X5 : Euclidean as X5,
  ]: Euclidean[(X1, X2, X3, X4, X5)] with

    override inline def divide
      (x: (X1, X2, X3, X4, X5), y: (X1, X2, X3, X4, X5))
      : (X1, X2, X3, X4, X5) = (
      X1.divide(x(0), y(0)),
      X2.divide(x(1), y(1)),
      X3.divide(x(2), y(2)),
      X4.divide(x(3), y(3)),
      X5.divide(x(4), y(4)),
    )

  given [
    X1 : Euclidean as X1,
    X2 : Euclidean as X2,
    X3 : Euclidean as X3,
    X4 : Euclidean as X4,
    X5 : Euclidean as X5,
    X6 : Euclidean as X6,
  ]: Euclidean[(X1, X2, X3, X4, X5, X6)] with

    override inline def divide
      (
        x: (X1, X2, X3, X4, X5, X6),
        y: (X1, X2, X3, X4, X5, X6),
      )
      : (X1, X2, X3, X4, X5, X6) = (
      X1.divide(x(0), y(0)),
      X2.divide(x(1), y(1)),
      X3.divide(x(2), y(2)),
      X4.divide(x(3), y(3)),
      X5.divide(x(4), y(4)),
      X6.divide(x(5), y(5)),
    )
