package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  */
trait QuotientMonoid[X] extends QuotientSemigroup[X], MultiplicativeMonoid[X]
