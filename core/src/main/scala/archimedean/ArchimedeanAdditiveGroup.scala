package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedAdditiveGroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanAdditiveGroup[X]
  extends ArchimedeanDifferenceMonoid[X],
          ArchimedeanAdditiveInverse[X],
          OrderedAdditiveGroup[X]
