package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemigroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Subtraction
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanDifferenceSemigroup[X]
  extends ArchimedeanDifference[X],
          ArchimedeanAdditiveSemigroup[X],
          OrderedDifferenceSemigroup[X]
