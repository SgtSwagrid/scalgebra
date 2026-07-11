package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Multiplicative identity (`1`)
  */
trait MultiplicativeIdentity[X] extends Algebra[X]:

  /**
    * The unique multiplicative identity in this algebra. Typically given by
    * values such as `1` or `1.0F`.
    */
  def one: X

  extension (x: X)

    /** @return `true` if and only if [[x]] equals [[one]]. */
    inline def isOne: Boolean = x == one

    /** @return `true` if and only if [[x]] doesn't equal [[one]]. */
    inline def nonOne: Boolean = !x.isOne

object MultiplicativeIdentity:

  /**
    * The unique multiplicative identity in this algebra. Typically given by
    * values such as `1` or `1.0F`.
    */
  inline def one[X : MultiplicativeIdentity as X]: X = X.one
