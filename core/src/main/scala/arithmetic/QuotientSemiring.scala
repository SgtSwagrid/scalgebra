package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  */
trait QuotientSemiring[X] extends Semiring[X], QuotientMonoid[X]:

  extension (x: X)

    /** A version of [[div]] which returns [[None]] when `y == zero`. */
    inline def divOption(y: X): Option[X] = Option.when(y.nonZero)(x / y)
