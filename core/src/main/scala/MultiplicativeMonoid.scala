package com.alecdorrington.scalgebra

/** For algebraic structures with multiplication and an identity. */
trait MultiplicativeMonoid[X]
  extends MultiplicativeSemigroup[X], MultiplicativeIdentity[X]:

  /**
    * Computes the product of all values in [[xs]], i.e. `xs₁ × xs₂ × …`, or
    * else [[one]] if [[xs]] is empty.
    */
  final inline def product(xs: Iterable[X]): X =
    productOption(xs).getOrElse(one)

  /**
    * Computes [[x]] raised to the power [[n]], for any non-negative [[n]].
    *
    * @throws IllegalArgumentException
    *   if `n < 0`.
    */
  override def pow(x: X, n: Int): X =

    require(
      n >= 0,
      s"Negative exponents ($n) aren't supported in this algebra.",
    )

    if n == 0 then one else super.pow(x, n)

/** The companion object for [[MultiplicativeMonoid]]. */
object MultiplicativeMonoid extends MultiplicativeMonoid.Ops:

  trait Ops extends MultiplicativeSemigroup.Ops, MultiplicativeIdentity.Ops:

    /**
      * Computes the product of all values in [[xs]], i.e. `xs₁ × xs₂ × …`, or
      * else [[one]] if [[xs]] is empty.
      */
    inline def product[X : MultiplicativeMonoid as X](xs: Iterable[X]): X = X
      .product(xs)

    /**
      * Computes [[x]] raised to the power [[n]], for any non-negative [[n]].
      *
      * @throws IllegalArgumentException
      *   if `n < 0`.
      */
    inline def pow[X : MultiplicativeMonoid as X](x: X, n: Int): X = X.pow(x, n)

  export com.alecdorrington.scalgebra.MultiplicativeMonoid

  /**
    * The [[MultiplicativeMonoid]] instance describing the current algebra
    * system.
    */
  inline def multiplicativeMonoid[
    X : MultiplicativeMonoid as multiplicativeMonoid,
  ]: MultiplicativeMonoid[X] = multiplicativeMonoid
