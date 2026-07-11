package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeGroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  *   - Total order
  */
trait OrderedMultiplicativeGroup[X]
  extends MultiplicativeGroup[X],
          OrderedQuotientMonoid[X],
          OrderedMultiplicativeInverse[X]
