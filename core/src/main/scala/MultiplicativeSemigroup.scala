package com.alecdorrington.scalgebra

/** For algebraic structures with an associative multiplication operator. */
trait MultiplicativeSemigroup[X] extends Root[X]:

  /**
    * Computes the product of two values [[x]] and [[y]], i.e. `x × y`.
    *
    * @note
    *   All implementations must be associative, i.e.
    *   `(x × y) × z == x × (y × z)`.
    */
  def multiply(x: X, y: X): X

  /**
    * Computes the product of all values in [[xs]], i.e. `xs₁ × xs₂ × …`, or
    * else [[None]] if [[xs]] is empty.
    */
  final inline def productOption(xs: Iterable[X]): Option[X] =
    xs.reduceOption(multiply)

  /**
    * Computes the product of [[x]] and all values in [[xs]]s, i.e.
    * `x × xs₁ × xs₂ × …`.
    */
  final inline def product(x: X, xs: X*): X = productOption(x +: xs).get

  /**
    * Computes [[x]] raised to the power [[n]], for any strictly positive [[n]].
    *
    * @throws IllegalArgumentException
    *   if `n ≤ 0`.
    */
  def pow(x: X, n: Int): X =

    require(
      n > 0,
      s"Non-positive exponents ($n) aren't supported in this algebra.",
    )

    def recurse(x: X, n: Int): X =
      if n == 1 then x
      else if n % 2 == 0 then recurse(multiply(x, x), n / 2)
      else multiply(x, recurse(x, n - 1))

    recurse(x, n)

  extension (x: X)

    /** Computes the product of two values [[x]] and [[y]], i.e. `x × y`. */
    inline infix def * (y: X): X = multiply(x, y)

    /** Alias of [[pow]], with the exponent on the right. */
    inline infix def ** (n: Int): X = pow(x, n)

/** The companion object for [[MultiplicativeSemigroup]]. */
object MultiplicativeSemigroup extends MultiplicativeSemigroup.Ops:

  trait Ops:

    /**
      * Computes the product of two values [[x]] and [[y]], i.e. `x × y`.
      *
      * @note
      *   All implementations must be associative, i.e.
      *   `(x × y) × z == x × (y × z)`.
      */
    inline def multiply[X : MultiplicativeSemigroup as X](x: X, y: X): X = X
      .multiply(x, y)

    /**
      * Computes the product of all values in [[xs]], i.e. `xs₁ × xs₂ × …`, or
      * else [[None]] if [[xs]] is empty.
      */
    inline def productOption[X : MultiplicativeSemigroup as X]
      (xs: Iterable[X])
      : Option[X] = X.productOption(xs)

    /**
      * Computes the product of [[x]] and all values in [[xs]]s, i.e.
      * `x × xs₁ × xs₂ × …`.
      */
    inline def product[X : MultiplicativeSemigroup as X](x: X, xs: X*): X = X
      .product(x, xs*)

    /**
      * Computes [[x]] raised to the power [[n]], for any strictly positive
      * [[n]].
      *
      * @throws IllegalArgumentException
      *   if `n ≤ 0`.
      */
    inline def pow[X : MultiplicativeSemigroup as X](x: X, n: Int): X =
      X.pow(x, n)

  export com.alecdorrington.scalgebra.MultiplicativeSemigroup

  /**
    * The [[MultiplicativeSemigroup]] instance describing the current algebra
    * system.
    */
  inline def multiplicativeSemigroup[
    X : MultiplicativeSemigroup as multiplicativeSemigroup,
  ]: MultiplicativeSemigroup[X] = multiplicativeSemigroup
