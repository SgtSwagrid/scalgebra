package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeMonoid

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Total order
  */
trait OrderedMultiplicativeMonoid[X]
  extends MultiplicativeMonoid[X],
          OrderedMultiplicativeSemigroup[X],
          OrderedMultiplicativeIdentity[X]
