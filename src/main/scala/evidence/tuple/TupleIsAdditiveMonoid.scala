package io.github.sgtswagrid.structures
package evidence.tuple

/**
  * Evidence that tuples of any arity up to 6 form an [[AdditiveMonoid]] under
  * componentwise addition, provided all element types have [[AdditiveMonoid]]
  * instances.
  */
trait TupleIsAdditiveMonoid:

  given [X : AdditiveMonoid as X]: AdditiveMonoid[X *: EmptyTuple] with

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple

    override inline def add
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.add(x.head, y.head) *: EmptyTuple

  given [
    X : AdditiveMonoid as X,
    Y : AdditiveMonoid as Y,
  ]: AdditiveMonoid[(X, Y)] with

    override def zero: (X, Y) = (X.zero, Y.zero)

    override inline def add(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.add(x(0), y(0)), Y.add(x(1), y(1)))

  given [
    X : AdditiveMonoid as X,
    Y : AdditiveMonoid as Y,
    Z : AdditiveMonoid as Z,
  ]: AdditiveMonoid[(X, Y, Z)] with

    override def zero: (X, Y, Z) = (X.zero, Y.zero, Z.zero)

    override inline def add(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.add(x(0), y(0)), Y.add(x(1), y(1)), Z.add(x(2), y(2)))

  given [
    X1 : AdditiveMonoid as X1,
    X2 : AdditiveMonoid as X2,
    X3 : AdditiveMonoid as X3,
    X4 : AdditiveMonoid as X4,
  ]: AdditiveMonoid[(X1, X2, X3, X4)] with

    override def zero: (X1, X2, X3, X4) = (X1.zero, X2.zero, X3.zero, X4.zero)

    override inline def add
      (x: (X1, X2, X3, X4), y: (X1, X2, X3, X4))
      : (X1, X2, X3, X4) = (
      X1.add(x(0), y(0)),
      X2.add(x(1), y(1)),
      X3.add(x(2), y(2)),
      X4.add(x(3), y(3)),
    )

  given [
    X1 : AdditiveMonoid as X1,
    X2 : AdditiveMonoid as X2,
    X3 : AdditiveMonoid as X3,
    X4 : AdditiveMonoid as X4,
    X5 : AdditiveMonoid as X5,
  ]: AdditiveMonoid[(X1, X2, X3, X4, X5)] with

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

  given [
    X1 : AdditiveMonoid as X1,
    X2 : AdditiveMonoid as X2,
    X3 : AdditiveMonoid as X3,
    X4 : AdditiveMonoid as X4,
    X5 : AdditiveMonoid as X5,
    X6 : AdditiveMonoid as X6,
  ]: AdditiveMonoid[(X1, X2, X3, X4, X5, X6)] with

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
