package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedQuotientMonoid

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanQuotientMonoid[X]
  extends ArchimedeanQuotientSemigroup[X],
          ArchimedeanMultiplicativeMonoid[X],
          OrderedQuotientMonoid[X]
