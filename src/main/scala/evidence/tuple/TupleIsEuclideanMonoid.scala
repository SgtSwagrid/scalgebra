package io.github.sgtswagrid.structures
package evidence.tuple

/**
  * Evidence that tuples of any arity up to 6 form an [[EuclideanMonoid]] under
  * componentwise multiplication and division, provided all element types have
  * [[EuclideanMonoid]] instances.
  */
trait TupleIsEuclideanMonoid:

  given [X : EuclideanMonoid as X]: EuclideanMonoid[X *: EmptyTuple] with

    override def one: X *: EmptyTuple = X.one *: EmptyTuple

    override inline def multiply
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.multiply(x.head, y.head) *: EmptyTuple

    override inline def divide
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.divide(x.head, y.head) *: EmptyTuple

  given [
    X : EuclideanMonoid as X,
    Y : EuclideanMonoid as Y,
  ]: EuclideanMonoid[(X, Y)] with

    override def one: (X, Y) = (X.one, Y.one)

    override inline def multiply(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.multiply(x(0), y(0)), Y.multiply(x(1), y(1)))

    override inline def divide(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.divide(x(0), y(0)), Y.divide(x(1), y(1)))

  given [
    X : EuclideanMonoid as X,
    Y : EuclideanMonoid as Y,
    Z : EuclideanMonoid as Z,
  ]: EuclideanMonoid[(X, Y, Z)] with

    override def one: (X, Y, Z) = (X.one, Y.one, Z.one)

    override inline def multiply(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.multiply(x(0), y(0)), Y.multiply(x(1), y(1)), Z.multiply(x(2), y(2)))

    override inline def divide(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.divide(x(0), y(0)), Y.divide(x(1), y(1)), Z.divide(x(2), y(2)))

  given [
    X1 : EuclideanMonoid as X1,
    X2 : EuclideanMonoid as X2,
    X3 : EuclideanMonoid as X3,
    X4 : EuclideanMonoid as X4,
  ]: EuclideanMonoid[(X1, X2, X3, X4)] with

    override def one: (X1, X2, X3, X4) = (X1.one, X2.one, X3.one, X4.one)

    override inline def multiply
      (x: (X1, X2, X3, X4), y: (X1, X2, X3, X4))
      : (X1, X2, X3, X4) = (
      X1.multiply(x(0), y(0)),
      X2.multiply(x(1), y(1)),
      X3.multiply(x(2), y(2)),
      X4.multiply(x(3), y(3)),
    )

    override inline def divide
      (x: (X1, X2, X3, X4), y: (X1, X2, X3, X4))
      : (X1, X2, X3, X4) = (
      X1.divide(x(0), y(0)),
      X2.divide(x(1), y(1)),
      X3.divide(x(2), y(2)),
      X4.divide(x(3), y(3)),
    )

  given [
    X1 : EuclideanMonoid as X1,
    X2 : EuclideanMonoid as X2,
    X3 : EuclideanMonoid as X3,
    X4 : EuclideanMonoid as X4,
    X5 : EuclideanMonoid as X5,
  ]: EuclideanMonoid[(X1, X2, X3, X4, X5)] with

    override def one: (X1, X2, X3, X4, X5) =
      (X1.one, X2.one, X3.one, X4.one, X5.one)

    override inline def multiply
      (x: (X1, X2, X3, X4, X5), y: (X1, X2, X3, X4, X5))
      : (X1, X2, X3, X4, X5) = (
      X1.multiply(x(0), y(0)),
      X2.multiply(x(1), y(1)),
      X3.multiply(x(2), y(2)),
      X4.multiply(x(3), y(3)),
      X5.multiply(x(4), y(4)),
    )

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
    X1 : EuclideanMonoid as X1,
    X2 : EuclideanMonoid as X2,
    X3 : EuclideanMonoid as X3,
    X4 : EuclideanMonoid as X4,
    X5 : EuclideanMonoid as X5,
    X6 : EuclideanMonoid as X6,
  ]: EuclideanMonoid[(X1, X2, X3, X4, X5, X6)] with

    override def one: (X1, X2, X3, X4, X5, X6) =
      (X1.one, X2.one, X3.one, X4.one, X5.one, X6.one)

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
