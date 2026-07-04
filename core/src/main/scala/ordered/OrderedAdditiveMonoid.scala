package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.AdditiveMonoid

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Total order
  */
trait OrderedAdditiveMonoid[X]
  extends AdditiveMonoid[X],
          OrderedAdditiveSemigroup[X],
          OrderedAdditiveIdentity[X]
