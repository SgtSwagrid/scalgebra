package io.github.sgtswagrid.structures
package evidence.tuple

/**
  * Evidence that tuples of any arity up to 6 have an [[AdditiveIdentity]],
  * provided all element types have [[AdditiveIdentity]] instances.
  */
trait TupleIsAdditiveIdentity:

  given [X : AdditiveIdentity as X]: AdditiveIdentity[X *: EmptyTuple] with
    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple

  given [
    X : AdditiveIdentity as X,
    Y : AdditiveIdentity as Y,
  ]: AdditiveIdentity[(X, Y)] with
    override def zero: (X, Y) = (X.zero, Y.zero)

  given [
    X : AdditiveIdentity as X,
    Y : AdditiveIdentity as Y,
    Z : AdditiveIdentity as Z,
  ]: AdditiveIdentity[(X, Y, Z)] with
    override def zero: (X, Y, Z) = (X.zero, Y.zero, Z.zero)

  given [
    X1 : AdditiveIdentity as X1,
    X2 : AdditiveIdentity as X2,
    X3 : AdditiveIdentity as X3,
    X4 : AdditiveIdentity as X4,
  ]: AdditiveIdentity[(X1, X2, X3, X4)] with
    override def zero: (X1, X2, X3, X4) = (X1.zero, X2.zero, X3.zero, X4.zero)

  given [
    X1 : AdditiveIdentity as X1,
    X2 : AdditiveIdentity as X2,
    X3 : AdditiveIdentity as X3,
    X4 : AdditiveIdentity as X4,
    X5 : AdditiveIdentity as X5,
  ]: AdditiveIdentity[(X1, X2, X3, X4, X5)] with

    override def zero: (X1, X2, X3, X4, X5) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero)

  given [
    X1 : AdditiveIdentity as X1,
    X2 : AdditiveIdentity as X2,
    X3 : AdditiveIdentity as X3,
    X4 : AdditiveIdentity as X4,
    X5 : AdditiveIdentity as X5,
    X6 : AdditiveIdentity as X6,
  ]: AdditiveIdentity[(X1, X2, X3, X4, X5, X6)] with

    override def zero: (X1, X2, X3, X4, X5, X6) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero, X6.zero)
