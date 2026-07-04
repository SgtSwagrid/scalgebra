package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedPseudoring

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanPseudoring[X]
  extends ArchimedeanAdditiveGroup[X],
          ArchimedeanMultiplicativeSemigroup[X],
          OrderedPseudoring[X]
