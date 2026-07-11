package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedQuotient

/**
  * A typeclass for algebraic values with the following features:
  *   - Division
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanQuotient[X] extends Archimedean[X], OrderedQuotient[X]
