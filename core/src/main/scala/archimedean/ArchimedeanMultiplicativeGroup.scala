package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeGroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanMultiplicativeGroup[X]
  extends ArchimedeanQuotientMonoid[X],
          ArchimedeanMultiplicativeInverse[X],
          OrderedMultiplicativeGroup[X]
