package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeIdentity

/**
  * A typeclass for algebraic values with the following features:
  *   - Multiplicative identity (`1`)
  *   - Total order
  */
trait OrderedMultiplicativeIdentity[X]
  extends MultiplicativeIdentity[X], Ordered[X]
