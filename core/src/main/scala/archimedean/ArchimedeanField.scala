package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedField

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanField[X]
  extends ArchimedeanQuotientRing[X],
          ArchimedeanDifferenceSemifield[X],
          OrderedField[X]
