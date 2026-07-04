package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Additive identity (`0`)
  */
trait AdditiveIdentity[X] extends Algebra[X]:

  /**
    * The unique additive identity in this algebra. Typically given by values
    * such as `0`, `0.0F`, or `Seq.empty`.
    */
  def zero: X

  extension (x: X)

    /** @return `true` if and only if [[x]] equals [[zero]]. */
    inline def isZero: Boolean = x == zero

    /** @return `true` if and only if [[x]] doesn't equal [[zero]]. */
    inline def nonZero: Boolean = x != zero

object AdditiveIdentity:

  /**
    * The unique additive identity in this algebra. Typically given by values
    * such as `0`, `0.0F`, or `Seq.empty`.
    */
  inline def zero[X : AdditiveIdentity as X]: X = X.zero
