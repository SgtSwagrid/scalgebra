package io.github.sgtswagrid.structures

import io.github.sgtswagrid.structures.builder.AdditiveSemigroupBuilder
import io.github.sgtswagrid.structures.ops.AdditiveSemigroupOps

/** For algebraic structures with an associative addition operator. */
trait AdditiveSemigroup[X]:

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

/**
  * The companion object for [[AdditiveSemigroup]]. Import as
  * {{{
  * import io.github.sgtswagrid.structures.AdditiveSemigroup.{*, given}
  * }}}
  * to receive all necessary syntax for working with additive semigroups.
  */
object AdditiveSemigroup extends AdditiveSemigroupBuilder, AdditiveSemigroupOps:

  export io.github.sgtswagrid.structures.AdditiveSemigroup

  /** The [[AdditiveSemigroup]] instance describing the current algebra system. */
  inline def additiveSemigroup[X : AdditiveSemigroup as additiveSemigroup]
    : AdditiveSemigroup[X] = additiveSemigroup
