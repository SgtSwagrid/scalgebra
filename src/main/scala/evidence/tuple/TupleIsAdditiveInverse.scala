package io.github.sgtswagrid.structures
package evidence.tuple

/**
  * Evidence that tuples of any arity up to 6 have an [[AdditiveInverse]] under
  * componentwise negation, provided all element types have [[AdditiveInverse]]
  * instances.
  */
trait TupleIsAdditiveInverse:

  given [X : AdditiveInverse as X]: AdditiveInverse[X *: EmptyTuple] with

    override inline def negate(x: X *: EmptyTuple): X *: EmptyTuple =
      X.negate(x.head) *: EmptyTuple

  given [
    X : AdditiveInverse as X,
    Y : AdditiveInverse as Y,
  ]: AdditiveInverse[(X, Y)] with

    override inline def negate(x: (X, Y)): (X, Y) =
      (X.negate(x(0)), Y.negate(x(1)))

  given [
    X : AdditiveInverse as X,
    Y : AdditiveInverse as Y,
    Z : AdditiveInverse as Z,
  ]: AdditiveInverse[(X, Y, Z)] with

    override inline def negate(x: (X, Y, Z)): (X, Y, Z) =
      (X.negate(x(0)), Y.negate(x(1)), Z.negate(x(2)))

  given [
    X1 : AdditiveInverse as X1,
    X2 : AdditiveInverse as X2,
    X3 : AdditiveInverse as X3,
    X4 : AdditiveInverse as X4,
  ]: AdditiveInverse[(X1, X2, X3, X4)] with

    override inline def negate(x: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
      (X1.negate(x(0)), X2.negate(x(1)), X3.negate(x(2)), X4.negate(x(3)))

  given [
    X1 : AdditiveInverse as X1,
    X2 : AdditiveInverse as X2,
    X3 : AdditiveInverse as X3,
    X4 : AdditiveInverse as X4,
    X5 : AdditiveInverse as X5,
  ]: AdditiveInverse[(X1, X2, X3, X4, X5)] with

    override inline def negate(x: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
      (
        X1.negate(x(0)),
        X2.negate(x(1)),
        X3.negate(x(2)),
        X4.negate(x(3)),
        X5.negate(x(4)),
      )

  given [
    X1 : AdditiveInverse as X1,
    X2 : AdditiveInverse as X2,
    X3 : AdditiveInverse as X3,
    X4 : AdditiveInverse as X4,
    X5 : AdditiveInverse as X5,
    X6 : AdditiveInverse as X6,
  ]: AdditiveInverse[(X1, X2, X3, X4, X5, X6)] with

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
