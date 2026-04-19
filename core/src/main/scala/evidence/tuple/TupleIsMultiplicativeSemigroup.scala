package com.alecdorrington.scalgebra
package evidence.tuple

/**
  * Evidence that tuples of any arity up to 6 form a [[MultiplicativeSemigroup]]
  * under componentwise multiplication, provided all element types have
  * [[MultiplicativeSemigroup]] instances.
  */
trait TupleIsMultiplicativeSemigroup:

  given [X : MultiplicativeSemigroup as X]
    : MultiplicativeSemigroup[X *: EmptyTuple] with

    override inline def multiply
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.multiply(x.head, y.head) *: EmptyTuple

  given [
    X : MultiplicativeSemigroup as X,
    Y : MultiplicativeSemigroup as Y,
  ]: MultiplicativeSemigroup[(X, Y)] with

    override inline def multiply(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.multiply(x(0), y(0)), Y.multiply(x(1), y(1)))

  given [
    X : MultiplicativeSemigroup as X,
    Y : MultiplicativeSemigroup as Y,
    Z : MultiplicativeSemigroup as Z,
  ]: MultiplicativeSemigroup[(X, Y, Z)] with

    override inline def multiply(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.multiply(x(0), y(0)), Y.multiply(x(1), y(1)), Z.multiply(x(2), y(2)))

  given [
    X1 : MultiplicativeSemigroup as X1,
    X2 : MultiplicativeSemigroup as X2,
    X3 : MultiplicativeSemigroup as X3,
    X4 : MultiplicativeSemigroup as X4,
  ]: MultiplicativeSemigroup[(X1, X2, X3, X4)] with

    override inline def multiply
      (x: (X1, X2, X3, X4), y: (X1, X2, X3, X4))
      : (X1, X2, X3, X4) = (
      X1.multiply(x(0), y(0)),
      X2.multiply(x(1), y(1)),
      X3.multiply(x(2), y(2)),
      X4.multiply(x(3), y(3)),
    )

  given [
    X1 : MultiplicativeSemigroup as X1,
    X2 : MultiplicativeSemigroup as X2,
    X3 : MultiplicativeSemigroup as X3,
    X4 : MultiplicativeSemigroup as X4,
    X5 : MultiplicativeSemigroup as X5,
  ]: MultiplicativeSemigroup[(X1, X2, X3, X4, X5)] with

    override inline def multiply
      (x: (X1, X2, X3, X4, X5), y: (X1, X2, X3, X4, X5))
      : (X1, X2, X3, X4, X5) = (
      X1.multiply(x(0), y(0)),
      X2.multiply(x(1), y(1)),
      X3.multiply(x(2), y(2)),
      X4.multiply(x(3), y(3)),
      X5.multiply(x(4), y(4)),
    )

  given [
    X1 : MultiplicativeSemigroup as X1,
    X2 : MultiplicativeSemigroup as X2,
    X3 : MultiplicativeSemigroup as X3,
    X4 : MultiplicativeSemigroup as X4,
    X5 : MultiplicativeSemigroup as X5,
    X6 : MultiplicativeSemigroup as X6,
  ]: MultiplicativeSemigroup[(X1, X2, X3, X4, X5, X6)] with

    override inline def multiply
      (
        x: (X1, X2, X3, X4, X5, X6),
        y: (X1, X2, X3, X4, X5, X6),
      )
      : (X1, X2, X3, X4, X5, X6) = (
      X1.multiply(x(0), y(0)),
      X2.multiply(x(1), y(1)),
      X3.multiply(x(2), y(2)),
      X4.multiply(x(3), y(3)),
      X5.multiply(x(4), y(4)),
      X6.multiply(x(5), y(5)),
    )
