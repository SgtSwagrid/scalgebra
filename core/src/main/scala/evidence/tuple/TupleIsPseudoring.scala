package com.alecdorrington.scalgebra
package evidence.tuple

/**
  * Evidence that tuples of any arity up to 6 form a [[Pseudoring]] under
  * componentwise negation, addition, and multiplication, provided all element
  * types have [[Pseudoring]] instances.
  */
trait TupleIsPseudoring:

  given [X : Pseudoring as X]: Pseudoring[X *: EmptyTuple] with

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple

    override inline def add
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.add(x.head, y.head) *: EmptyTuple

    override inline def multiply
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.multiply(x.head, y.head) *: EmptyTuple

    override inline def negate(x: X *: EmptyTuple): X *: EmptyTuple =
      X.negate(x.head) *: EmptyTuple

  given [X : Pseudoring as X, Y : Pseudoring as Y]: Pseudoring[(X, Y)] with

    override def zero: (X, Y) = (X.zero, Y.zero)

    override inline def add(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.add(x(0), y(0)), Y.add(x(1), y(1)))

    override inline def multiply(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.multiply(x(0), y(0)), Y.multiply(x(1), y(1)))

    override inline def negate(x: (X, Y)): (X, Y) =
      (X.negate(x(0)), Y.negate(x(1)))

  given [
    X : Pseudoring as X,
    Y : Pseudoring as Y,
    Z : Pseudoring as Z,
  ]: Pseudoring[(X, Y, Z)] with

    override def zero: (X, Y, Z) = (X.zero, Y.zero, Z.zero)

    override inline def add(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.add(x(0), y(0)), Y.add(x(1), y(1)), Z.add(x(2), y(2)))

    override inline def multiply(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.multiply(x(0), y(0)), Y.multiply(x(1), y(1)), Z.multiply(x(2), y(2)))

    override inline def negate(x: (X, Y, Z)): (X, Y, Z) =
      (X.negate(x(0)), Y.negate(x(1)), Z.negate(x(2)))

  given [
    X1 : Pseudoring as X1,
    X2 : Pseudoring as X2,
    X3 : Pseudoring as X3,
    X4 : Pseudoring as X4,
  ]: Pseudoring[(X1, X2, X3, X4)] with

    override def zero: (X1, X2, X3, X4) = (X1.zero, X2.zero, X3.zero, X4.zero)

    override inline def add
      (x: (X1, X2, X3, X4), y: (X1, X2, X3, X4))
      : (X1, X2, X3, X4) = (
      X1.add(x(0), y(0)),
      X2.add(x(1), y(1)),
      X3.add(x(2), y(2)),
      X4.add(x(3), y(3)),
    )

    override inline def multiply
      (x: (X1, X2, X3, X4), y: (X1, X2, X3, X4))
      : (X1, X2, X3, X4) = (
      X1.multiply(x(0), y(0)),
      X2.multiply(x(1), y(1)),
      X3.multiply(x(2), y(2)),
      X4.multiply(x(3), y(3)),
    )

    override inline def negate(x: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
      (X1.negate(x(0)), X2.negate(x(1)), X3.negate(x(2)), X4.negate(x(3)))

  given [
    X1 : Pseudoring as X1,
    X2 : Pseudoring as X2,
    X3 : Pseudoring as X3,
    X4 : Pseudoring as X4,
    X5 : Pseudoring as X5,
  ]: Pseudoring[(X1, X2, X3, X4, X5)] with

    override def zero: (X1, X2, X3, X4, X5) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero)

    override inline def add
      (x: (X1, X2, X3, X4, X5), y: (X1, X2, X3, X4, X5))
      : (X1, X2, X3, X4, X5) = (
      X1.add(x(0), y(0)),
      X2.add(x(1), y(1)),
      X3.add(x(2), y(2)),
      X4.add(x(3), y(3)),
      X5.add(x(4), y(4)),
    )

    override inline def multiply
      (x: (X1, X2, X3, X4, X5), y: (X1, X2, X3, X4, X5))
      : (X1, X2, X3, X4, X5) = (
      X1.multiply(x(0), y(0)),
      X2.multiply(x(1), y(1)),
      X3.multiply(x(2), y(2)),
      X4.multiply(x(3), y(3)),
      X5.multiply(x(4), y(4)),
    )

    override inline def negate(x: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
      (
        X1.negate(x(0)),
        X2.negate(x(1)),
        X3.negate(x(2)),
        X4.negate(x(3)),
        X5.negate(x(4)),
      )

  given [
    X1 : Pseudoring as X1,
    X2 : Pseudoring as X2,
    X3 : Pseudoring as X3,
    X4 : Pseudoring as X4,
    X5 : Pseudoring as X5,
    X6 : Pseudoring as X6,
  ]: Pseudoring[(X1, X2, X3, X4, X5, X6)] with

    override def zero: (X1, X2, X3, X4, X5, X6) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero, X6.zero)

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

    override inline def negate
      (x: (X1, X2, X3, X4, X5, X6))
      : (X1, X2, X3, X4, X5, X6) = (
      X1.negate(x(0)),
      X2.negate(x(1)),
      X3.negate(x(2)),
      X4.negate(x(3)),
      X5.negate(x(4)),
      X6.negate(x(5)),
    )
