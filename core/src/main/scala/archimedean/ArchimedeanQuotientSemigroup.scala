package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedQuotientSemigroup

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative multiplication
  *   - Division
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanQuotientSemigroup[X]
  extends ArchimedeanQuotient[X],
          ArchimedeanMultiplicativeSemigroup[X],
          OrderedQuotientSemigroup[X]
