package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemifield

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Subtraction
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanDifferenceSemifield[X]
  extends ArchimedeanQuotientDifferenceSemiring[X],
          ArchimedeanSemifield[X],
          OrderedDifferenceSemifield[X]
