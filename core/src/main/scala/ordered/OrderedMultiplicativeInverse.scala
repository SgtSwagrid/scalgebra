package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeInverse

/**
  * A typeclass for algebraic values with the following features:
  *   - Multiplicative inverse (reciprocation)
  *   - Total order
  */
trait OrderedMultiplicativeInverse[X]
  extends MultiplicativeInverse[X], Ordered[X]
