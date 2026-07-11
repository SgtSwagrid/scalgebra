package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Division
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Cancellation: `(x × y) / y == x`, whenever the division is defined.
  */
trait QuotientSemigroup[X] extends MultiplicativeSemigroup[X], Quotient[X]
