package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Commutativity: `x + y == y + x`.
  *   - Distributivity: `x × (y + z) == (x × y) + (x × z)` and
  *     `(x + y) × z == (x × z) + (y × z)`.
  *   - Annihilation: `x × zero == zero × x == zero`.
  */
trait Semiring[X] extends AdditiveMonoid[X], MultiplicativeMonoid[X]:

  /**
    * Computes the canonical representation of the integer [[n]] in this
    * algebra, i.e. `1 + 1 + … + 1` ([[n]] times).
    *
    * @throws IllegalArgumentException
    *   if `n < 0` and this algebra has no additive inverse.
    */
  def fromInt(n: Int): X = one.scale(n)

object Semiring:

  /**
    * Computes the canonical representation of the integer [[n]] in this
    * algebra, i.e. `1 + 1 + … + 1` ([[n]] times).
    *
    * @throws IllegalArgumentException
    *   if `n < 0` and this algebra has no additive inverse.
    */
  inline def fromInt[X : Semiring as X](n: Int): X = X.fromInt(n)
