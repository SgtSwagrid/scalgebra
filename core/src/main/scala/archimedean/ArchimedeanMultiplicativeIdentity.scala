package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeIdentity

/**
  * A typeclass for algebraic values with the following features:
  *   - Multiplicative identity (`1`)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanMultiplicativeIdentity[X]
  extends Archimedean[X], OrderedMultiplicativeIdentity[X]
