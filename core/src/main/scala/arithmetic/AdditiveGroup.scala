package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Inversion: `x + -x == -x + x == zero`.
  */
trait AdditiveGroup[X] extends DifferenceMonoid[X], AdditiveInverse[X]:

  extension (x: X)

    override def subtract(y: X): X = x + y.negate

    /** Computes [[x]] multiplied by [[n]], for any integer [[n]]. */
    override def scale(n: Int): X =
      if n == Int.MinValue then x.negate.scale(Int.MaxValue) + x.negate
      else super.scale(if n >= 0 then x else x.negate)(n.abs)
