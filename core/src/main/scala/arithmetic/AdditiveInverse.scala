package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Additive inverse (negation)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Involution: `-(-x) == x`.
  */
trait AdditiveInverse[X] extends Algebra[X]:

  extension (x: X)

    /** Computes the additive inverse (negative) of a value [[x]], i.e. `-x`. */
    def negate: X

    /** An alias for [[negate]]. */
    inline def unary_- : X = x.negate
