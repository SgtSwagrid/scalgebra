package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.DifferenceMonoid

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Subtraction
  *   - Total order
  */
trait OrderedDifferenceMonoid[X]
  extends DifferenceMonoid[X],
          OrderedDifferenceSemigroup[X],
          OrderedAdditiveMonoid[X]
