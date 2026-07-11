package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedRing

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanRing[X]
  extends ArchimedeanPseudoring[X],
          ArchimedeanDifferenceSemiring[X],
          OrderedRing[X]
