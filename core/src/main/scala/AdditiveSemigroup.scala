package com.alecdorrington.scalgebra

/** For algebraic structures with an associative addition operator. */
trait AdditiveSemigroup[X] extends Root[X]:

  /**
    * Computes the sum of two values [[x]] and [[y]], i.e. `x + y`.
    *
    * @note
    *   All implementations must be associative, i.e.
    *   `(x + y) + z == x + (y + z)`.
    */
  def add(x: X, y: X): X

  /**
    * Computes the sum of all values in [[xs]], i.e. `xs₁ + xs₂ + …`, or else
    * [[None]] if [[xs]] is empty.
    */
  final def sumOption(xs: Iterable[X]): Option[X] = xs.reduceOption(add)

  /**
    * Computes the sum of [[x]] and all values in [[xs]], i.e.
    * `x + xs₁ + xs₂ + …`.
    */
  final inline def sum(x: X, xs: X*): X = sumOption(x +: xs).get

  /**
    * Computes [[x]] multiplied by [[n]], for any strictly positive [[n]].
    *
    * @throws IllegalArgumentException
    *   if `n ≤ 0`.
    */
  def scale(x: X, n: Int): X =

    require(
      n > 0,
      s"Non-positive multipliers ($n) aren't supported in this algebra.",
    )

    def recurse(x: X, n: Int): X =
      if n == 1 then x
      else if n % 2 == 0 then recurse(add(x, x), n / 2)
      else add(x, recurse(x, n - 1))

    recurse(x, n)

  extension (x: X)

    /** Computes the sum of two values [[x]] and [[y]], i.e. `x + y`. */
    inline infix def + (y: X): X = add(x, y)

    /** Alias of [[scale]], with the factor on the left. */
    inline infix def *: (n: Int): X = scale(x, n)

    /** Alias of [[scale]], with the factor on the right. */
    inline infix def :* (n: Int): X = scale(x, n)

/** The companion object for [[AdditiveSemigroup]]. */
object AdditiveSemigroup extends AdditiveSemigroup.Ops:

  trait Ops:

    /**
      * Computes the sum of two values [[x]] and [[y]], i.e. `x + y`.
      *
      * @note
      *   All implementations must be associative, i.e.
      *   `(x + y) + z == x + (y + z)`.
      */
    inline def add[X : AdditiveSemigroup as X](x: X, y: X): X = X.add(x, y)

    /**
      * Computes the sum of all values in [[xs]], i.e. `xs₁ + xs₂ + …`, or else
      * [[None]] if [[xs]] is empty.
      */
    inline def sumOption[X : AdditiveSemigroup as X]
      (xs: Iterable[X])
      : Option[X] = X.sumOption(xs)

    /**
      * Computes the sum of [[x]] and all values in [[xs]], i.e.
      * `x + xs₁ + xs₂ + …`.
      */
    inline def sum[X : AdditiveSemigroup as X](x: X, xs: X*): X = X.sum(x, xs*)

    /**
      * Computes [[x]] multiplied by [[n]], for any strictly positive [[n]].
      *
      * @throws IllegalArgumentException
      *   if `n ≤ 0`.
      */
    inline def scale[X : AdditiveSemigroup as X](x: X, n: Int): X =
      X.scale(x, n)

  export com.alecdorrington.scalgebra.AdditiveSemigroup

  /** The [[AdditiveSemigroup]] instance describing the current algebra system. */
  inline def additiveSemigroup[X : AdditiveSemigroup as additiveSemigroup]
    : AdditiveSemigroup[X] = additiveSemigroup
