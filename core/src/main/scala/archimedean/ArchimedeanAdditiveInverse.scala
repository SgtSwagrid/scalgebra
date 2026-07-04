package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedAdditiveInverse

/**
  * A typeclass for algebraic values with the following features:
  *   - Additive inverse (negation)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanAdditiveInverse[X]
  extends Archimedean[X], OrderedAdditiveInverse[X]:

  extension (x: X)

    override def ceil: X = x.negate.floor.negate
