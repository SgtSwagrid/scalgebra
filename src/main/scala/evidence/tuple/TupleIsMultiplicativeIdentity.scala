package com.alecdorrington.scalgebra
package evidence.tuple

/**
  * Evidence that tuples of any arity up to 6 have a [[MultiplicativeIdentity]]
  * under componentwise `one`, provided all element types have
  * [[MultiplicativeIdentity]] instances.
  */
trait TupleIsMultiplicativeIdentity:

  given [X : MultiplicativeIdentity as X]
    : MultiplicativeIdentity[X *: EmptyTuple] with
    override def one: X *: EmptyTuple = X.one *: EmptyTuple

  given [
    X : MultiplicativeIdentity as X,
    Y : MultiplicativeIdentity as Y,
  ]: MultiplicativeIdentity[(X, Y)] with
    override def one: (X, Y) = (X.one, Y.one)

  given [
    X : MultiplicativeIdentity as X,
    Y : MultiplicativeIdentity as Y,
    Z : MultiplicativeIdentity as Z,
  ]: MultiplicativeIdentity[(X, Y, Z)] with
    override def one: (X, Y, Z) = (X.one, Y.one, Z.one)

  given [
    X1 : MultiplicativeIdentity as X1,
    X2 : MultiplicativeIdentity as X2,
    X3 : MultiplicativeIdentity as X3,
    X4 : MultiplicativeIdentity as X4,
  ]: MultiplicativeIdentity[(X1, X2, X3, X4)] with
    override def one: (X1, X2, X3, X4) = (X1.one, X2.one, X3.one, X4.one)

  given [
    X1 : MultiplicativeIdentity as X1,
    X2 : MultiplicativeIdentity as X2,
    X3 : MultiplicativeIdentity as X3,
    X4 : MultiplicativeIdentity as X4,
    X5 : MultiplicativeIdentity as X5,
  ]: MultiplicativeIdentity[(X1, X2, X3, X4, X5)] with

    override def one: (X1, X2, X3, X4, X5) =
      (X1.one, X2.one, X3.one, X4.one, X5.one)

  given [
    X1 : MultiplicativeIdentity as X1,
    X2 : MultiplicativeIdentity as X2,
    X3 : MultiplicativeIdentity as X3,
    X4 : MultiplicativeIdentity as X4,
    X5 : MultiplicativeIdentity as X5,
    X6 : MultiplicativeIdentity as X6,
  ]: MultiplicativeIdentity[(X1, X2, X3, X4, X5, X6)] with

    override def one: (X1, X2, X3, X4, X5, X6) =
      (X1.one, X2.one, X3.one, X4.one, X5.one, X6.one)
