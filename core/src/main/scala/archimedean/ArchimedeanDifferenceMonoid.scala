package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedDifferenceMonoid

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Subtraction
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanDifferenceMonoid[X]
  extends ArchimedeanDifferenceSemigroup[X],
          ArchimedeanAdditiveMonoid[X],
          OrderedDifferenceMonoid[X]
