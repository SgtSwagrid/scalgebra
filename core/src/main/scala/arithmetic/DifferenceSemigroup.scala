package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Subtraction
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Cancellation: `(x + y) - y == x`.
  */
trait DifferenceSemigroup[X] extends AdditiveSemigroup[X], Difference[X]
