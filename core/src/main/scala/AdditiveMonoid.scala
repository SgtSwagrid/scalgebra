package com.alecdorrington.scalgebra

/** For algebraic structures with addition and an identity. */
trait AdditiveMonoid[X] extends AdditiveSemigroup[X], AdditiveIdentity[X]:

  /**
    * Computes the sum of all values in [[xs]], i.e. `xs₁ + xs₂ + …`, or else
    * [[zero]] if [[xs]] is empty.
    */
  final inline def sum(xs: Iterable[X]): X = sumOption(xs).getOrElse(zero)

  /**
    * Computes [[x]] multiplied by [[n]], for any non-negative [[n]].
    *
    * @throws IllegalArgumentException
    *   if `n < 0`.
    */
  override def scale(x: X, n: Int): X =

    require(
      n >= 0,
      s"Negative multipliers ($n) aren't supported in this algebra.",
    )

    if n == 0 then zero else super.scale(x, n)

/** The companion object for [[AdditiveMonoid]]. */
object AdditiveMonoid extends AdditiveMonoid.Ops:

  trait Ops extends AdditiveSemigroup.Ops, AdditiveIdentity.Ops:

    /**
      * Computes the sum of all values in [[xs]], i.e. `xs₁ + xs₂ + …`, or else
      * [[zero]] if [[xs]] is empty.
      */
    inline def sum[X : AdditiveMonoid as X](xs: Iterable[X]): X = X.sum(xs)

    /**
      * Computes [[x]] multiplied by [[n]], for any non-negative [[n]].
      *
      * @throws IllegalArgumentException
      *   if `n < 0`.
      */
    inline def scale[X : AdditiveMonoid as X](x: X, n: Int): X = X.scale(x, n)

  export com.alecdorrington.scalgebra.AdditiveMonoid

  /** The [[AdditiveMonoid]] instance describing the current algebra system. */
  inline def additiveMonoid[X : AdditiveMonoid as additiveMonoid]
    : AdditiveMonoid[X] = additiveMonoid
