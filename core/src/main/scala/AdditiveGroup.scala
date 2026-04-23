package com.alecdorrington.scalgebra

/** For algebraic structures with addition and negation. */
trait AdditiveGroup[X] extends DifferenceMonoid[X], AdditiveInverse[X]:

  override inline def subtract(x: X, y: X): X = add(x, negate(y))

  /** Computes [[x]] multiplied by [[n]], for any integer [[n]]. */
  override def scale(x: X, n: Int): X =
    super.scale(if n >= 0 then x else negate(x), n.abs)

/** The companion object for [[AdditiveGroup]]. */
object AdditiveGroup extends AdditiveGroup.Ops:

  trait Ops extends DifferenceMonoid.Ops, AdditiveInverse.Ops:

    /**
      * Computes the difference between two values [[x]] and [[y]], i.e.
      * `x - y`.
      */
    inline def subtract[X : AdditiveGroup as X](x: X, y: X): X =
      X.subtract(x, y)

    /** Computes [[x]] multiplied by [[n]], for any integer [[n]]. */
    inline def scale[X : AdditiveGroup as X](x: X, n: Int): X = X.scale(x, n)

  export com.alecdorrington.scalgebra.AdditiveGroup

  /** The [[AdditiveGroup]] instance describing the current algebra system. */
  inline def additiveGroup[X : AdditiveGroup as additiveGroup]
    : AdditiveGroup[X] = additiveGroup
