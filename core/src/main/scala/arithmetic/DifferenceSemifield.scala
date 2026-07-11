package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Subtraction
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  */
trait DifferenceSemifield[X] extends QuotientDifferenceSemiring[X], Semifield[X]
