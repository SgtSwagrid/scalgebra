package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Multiplicative inverse (reciprocation)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Involution: `x.reciprocal.reciprocal == x`.
  */
trait MultiplicativeInverse[X] extends Algebra[X]:

  extension (x: X)

    /**
      * Computes the multiplicative inverse (reciprocal) of a value [[x]], i.e.
      * `1 / x`.
      *
      * @throws ArithmeticException
      *   if `x == zero`.
      */
    def reciprocal: X
