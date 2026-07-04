package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  */
trait Semifield[X] extends QuotientSemiring[X], MultiplicativeGroup[X]:

  extension (x: X)

    /** A version of [[reciprocal]] which returns [[None]] when `x == zero`. */
    inline def reciprocalOption: Option[X] =
      Option.when(x.nonZero)(x.reciprocal)
