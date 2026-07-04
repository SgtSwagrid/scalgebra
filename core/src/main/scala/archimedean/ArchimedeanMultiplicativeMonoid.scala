package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeMonoid

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanMultiplicativeMonoid[X]
  extends ArchimedeanMultiplicativeSemigroup[X],
          ArchimedeanMultiplicativeIdentity[X],
          OrderedMultiplicativeMonoid[X]
