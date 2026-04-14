package io.github.sgtswagrid.structures
package evidence.tuple

/**
  * Evidence that tuples of any arity up to 6 form a [[Ring]] under
  * componentwise negation, addition, and multiplication, provided all element
  * types have [[Ring]] instances.
  */
trait TupleIsRing:

  given [X : Ring as X]: Ring[X *: EmptyTuple] with

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple
    override def one: X *: EmptyTuple  = X.one *: EmptyTuple

    override inline def add
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.add(x.head, y.head) *: EmptyTuple

    override inline def multiply
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.multiply(x.head, y.head) *: EmptyTuple

    override inline def negate(x: X *: EmptyTuple): X *: EmptyTuple =
      X.negate(x.head) *: EmptyTuple

  given [X : Ring as X, Y : Ring as Y]: Ring[(X, Y)] with

    override def zero: (X, Y) = (X.zero, Y.zero)
    override def one: (X, Y)  = (X.one, Y.one)

    override inline def add(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.add(x(0), y(0)), Y.add(x(1), y(1)))

    override inline def multiply(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.multiply(x(0), y(0)), Y.multiply(x(1), y(1)))

    override inline def negate(x: (X, Y)): (X, Y) =
      (X.negate(x(0)), Y.negate(x(1)))

  given [X : Ring as X, Y : Ring as Y, Z : Ring as Z]: Ring[(X, Y, Z)] with

    override def zero: (X, Y, Z) = (X.zero, Y.zero, Z.zero)
    override def one: (X, Y, Z)  = (X.one, Y.one, Z.one)

    override inline def add(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.add(x(0), y(0)), Y.add(x(1), y(1)), Z.add(x(2), y(2)))

    override inline def multiply(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.multiply(x(0), y(0)), Y.multiply(x(1), y(1)), Z.multiply(x(2), y(2)))

    override inline def negate(x: (X, Y, Z)): (X, Y, Z) =
      (X.negate(x(0)), Y.negate(x(1)), Z.negate(x(2)))

  given [
    X1 : Ring as X1,
    X2 : Ring as X2,
    X3 : Ring as X3,
    X4 : Ring as X4,
  ]: Ring[(X1, X2, X3, X4)] with

    override def zero: (X1, X2, X3, X4) = (X1.zero, X2.zero, X3.zero, X4.zero)
    override def one: (X1, X2, X3, X4)  = (X1.one, X2.one, X3.one, X4.one)

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
    X1 : Ring as X1,
    X2 : Ring as X2,
    X3 : Ring as X3,
    X4 : Ring as X4,
    X5 : Ring as X5,
  ]: Ring[(X1, X2, X3, X4, X5)] with

    override def zero: (X1, X2, X3, X4, X5) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero)

    override def one: (X1, X2, X3, X4, X5) =
      (X1.one, X2.one, X3.one, X4.one, X5.one)

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
    X1 : Ring as X1,
    X2 : Ring as X2,
    X3 : Ring as X3,
    X4 : Ring as X4,
    X5 : Ring as X5,
    X6 : Ring as X6,
  ]: Ring[(X1, X2, X3, X4, X5, X6)] with

    override def zero: (X1, X2, X3, X4, X5, X6) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero, X6.zero)

    override def one: (X1, X2, X3, X4, X5, X6) =
      (X1.one, X2.one, X3.one, X4.one, X5.one, X6.one)

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
