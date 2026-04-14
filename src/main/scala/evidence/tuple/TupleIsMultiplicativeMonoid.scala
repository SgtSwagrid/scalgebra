package io.github.sgtswagrid.structures
package evidence.tuple

/**
  * Evidence that tuples of any arity up to 6 form a [[MultiplicativeMonoid]]
  * under componentwise multiplication, provided all element types have
  * [[MultiplicativeMonoid]] instances.
  */
trait TupleIsMultiplicativeMonoid:

  given [X : MultiplicativeMonoid as X]: MultiplicativeMonoid[X *: EmptyTuple]
  with

    override def one: X *: EmptyTuple = X.one *: EmptyTuple

    override inline def multiply
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.multiply(x.head, y.head) *: EmptyTuple

  given [
    X : MultiplicativeMonoid as X,
    Y : MultiplicativeMonoid as Y,
  ]: MultiplicativeMonoid[(X, Y)] with

    override def one: (X, Y) = (X.one, Y.one)

    override inline def multiply(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.multiply(x(0), y(0)), Y.multiply(x(1), y(1)))

  given [
    X : MultiplicativeMonoid as X,
    Y : MultiplicativeMonoid as Y,
    Z : MultiplicativeMonoid as Z,
  ]: MultiplicativeMonoid[(X, Y, Z)] with

    override def one: (X, Y, Z) = (X.one, Y.one, Z.one)

    override inline def multiply(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.multiply(x(0), y(0)), Y.multiply(x(1), y(1)), Z.multiply(x(2), y(2)))

  given [
    X1 : MultiplicativeMonoid as X1,
    X2 : MultiplicativeMonoid as X2,
    X3 : MultiplicativeMonoid as X3,
    X4 : MultiplicativeMonoid as X4,
  ]: MultiplicativeMonoid[(X1, X2, X3, X4)] with

    override def one: (X1, X2, X3, X4) = (X1.one, X2.one, X3.one, X4.one)

    override inline def multiply
      (x: (X1, X2, X3, X4), y: (X1, X2, X3, X4))
      : (X1, X2, X3, X4) = (
      X1.multiply(x(0), y(0)),
      X2.multiply(x(1), y(1)),
      X3.multiply(x(2), y(2)),
      X4.multiply(x(3), y(3)),
    )

  given [
    X1 : MultiplicativeMonoid as X1,
    X2 : MultiplicativeMonoid as X2,
    X3 : MultiplicativeMonoid as X3,
    X4 : MultiplicativeMonoid as X4,
    X5 : MultiplicativeMonoid as X5,
  ]: MultiplicativeMonoid[(X1, X2, X3, X4, X5)] with

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

  given [
    X1 : MultiplicativeMonoid as X1,
    X2 : MultiplicativeMonoid as X2,
    X3 : MultiplicativeMonoid as X3,
    X4 : MultiplicativeMonoid as X4,
    X5 : MultiplicativeMonoid as X5,
    X6 : MultiplicativeMonoid as X6,
  ]: MultiplicativeMonoid[(X1, X2, X3, X4, X5, X6)] with

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
