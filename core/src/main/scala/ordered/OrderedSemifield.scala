package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.Semifield

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  *   - Total order
  */
trait OrderedSemifield[X]
  extends Semifield[X],
          OrderedQuotientSemiring[X],
          OrderedMultiplicativeGroup[X]
