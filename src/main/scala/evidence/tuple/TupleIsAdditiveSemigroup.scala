package io.github.sgtswagrid.structures
package evidence.tuple

/**
  * Evidence that tuples of any arity up to 6 form an [[AdditiveSemigroup]]
  * under componentwise addition, provided all element types have
  * [[AdditiveSemigroup]] instances.
  */
trait TupleIsAdditiveSemigroup:

  given [X : AdditiveSemigroup as X]: AdditiveSemigroup[X *: EmptyTuple] with

    override inline def add
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.add(x.head, y.head) *: EmptyTuple

  given [
    X : AdditiveSemigroup as X,
    Y : AdditiveSemigroup as Y,
  ]: AdditiveSemigroup[(X, Y)] with

    override inline def add(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.add(x(0), y(0)), Y.add(x(1), y(1)))

  given [
    X : AdditiveSemigroup as X,
    Y : AdditiveSemigroup as Y,
    Z : AdditiveSemigroup as Z,
  ]: AdditiveSemigroup[(X, Y, Z)] with

    override inline def add(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.add(x(0), y(0)), Y.add(x(1), y(1)), Z.add(x(2), y(2)))

  given [
    X1 : AdditiveSemigroup as X1,
    X2 : AdditiveSemigroup as X2,
    X3 : AdditiveSemigroup as X3,
    X4 : AdditiveSemigroup as X4,
  ]: AdditiveSemigroup[(X1, X2, X3, X4)] with

    override inline def add
      (x: (X1, X2, X3, X4), y: (X1, X2, X3, X4))
      : (X1, X2, X3, X4) = (
      X1.add(x(0), y(0)),
      X2.add(x(1), y(1)),
      X3.add(x(2), y(2)),
      X4.add(x(3), y(3)),
    )

  given [
    X1 : AdditiveSemigroup as X1,
    X2 : AdditiveSemigroup as X2,
    X3 : AdditiveSemigroup as X3,
    X4 : AdditiveSemigroup as X4,
    X5 : AdditiveSemigroup as X5,
  ]: AdditiveSemigroup[(X1, X2, X3, X4, X5)] with

    override inline def add
      (x: (X1, X2, X3, X4, X5), y: (X1, X2, X3, X4, X5))
      : (X1, X2, X3, X4, X5) = (
      X1.add(x(0), y(0)),
      X2.add(x(1), y(1)),
      X3.add(x(2), y(2)),
      X4.add(x(3), y(3)),
      X5.add(x(4), y(4)),
    )

  given [
    X1 : AdditiveSemigroup as X1,
    X2 : AdditiveSemigroup as X2,
    X3 : AdditiveSemigroup as X3,
    X4 : AdditiveSemigroup as X4,
    X5 : AdditiveSemigroup as X5,
    X6 : AdditiveSemigroup as X6,
  ]: AdditiveSemigroup[(X1, X2, X3, X4, X5, X6)] with

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
