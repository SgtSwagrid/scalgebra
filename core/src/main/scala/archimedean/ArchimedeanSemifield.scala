package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedSemifield

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanSemifield[X]
  extends ArchimedeanQuotientSemiring[X],
          ArchimedeanMultiplicativeGroup[X],
          OrderedSemifield[X]
