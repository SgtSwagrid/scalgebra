package com.alecdorrington.scalgebra

/** For algebraic structures with both addition and multiplication. */
trait Semiring[X] extends AdditiveMonoid[X], MultiplicativeMonoid[X]:

  /** The unique representation of `2` in this algebra system. */
  def two: X = add(one, one)

/** The companion object for [[Semiring]]. */
object Semiring extends Semiring.Ops:

  trait Ops extends AdditiveMonoid.Ops, MultiplicativeMonoid.Ops:
    inline def two[X : Semiring as X]: X = X.two

  export com.alecdorrington.scalgebra.Semiring

  /** The [[Semiring]] instance describing the current algebra system. */
  inline def semiring[X : Semiring as semiring]: Semiring[X] = semiring
