package com.alecdorrington.scalgebra
package evidence
package collection

/**
  * Evidence that [[Either]] forms an [[AdditiveMonoid]] under
  * error-accumulating addition, provided the error type has an
  * [[AdditiveSemigroup]] and the success type has an [[AdditiveMonoid]].
  *
  * [[Right]] values are combined pairwise; two [[Left]] errors are accumulated
  * via the error semigroup; and [[Left]] absorbs [[Right]] on either side.
  */
trait EitherIsAdditiveMonoid:

  given [
    X : AdditiveSemigroup as X,
    Y : AdditiveMonoid as Y,
  ]: AdditiveMonoid[Either[X, Y]] with

    override def zero: Either[X, Y] = Right(Y.zero)

    override def add(x: Either[X, Y], y: Either[X, Y]): Either[X, Y] =
      (x, y) match
        case (Right(y1), Right(y2)) => Right(Y.add(y1, y2))
        case (Left(x1), Left(x2))   => Left(X.add(x1, x2))
        case (Left(e), _)           => Left(e)
        case (_, Left(e))           => Left(e)
