package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedSemiring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanSemiring[X]
  extends ArchimedeanAdditiveMonoid[X],
          ArchimedeanMultiplicativeMonoid[X],
          OrderedSemiring[X]
