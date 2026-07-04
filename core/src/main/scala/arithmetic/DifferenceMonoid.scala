package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Subtraction
  */
trait DifferenceMonoid[X] extends DifferenceSemigroup[X], AdditiveMonoid[X]
