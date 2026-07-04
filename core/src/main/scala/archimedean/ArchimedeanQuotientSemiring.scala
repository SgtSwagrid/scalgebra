package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedQuotientSemiring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Division
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanQuotientSemiring[X]
  extends ArchimedeanSemiring[X],
          ArchimedeanQuotientMonoid[X],
          OrderedQuotientSemiring[X]
