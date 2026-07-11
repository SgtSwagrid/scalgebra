package com.alecdorrington.scalgebra
package archimedean

import com.alecdorrington.scalgebra.ordered.OrderedAdditiveMonoid

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Total order
  *   - Rounding to integer values
  */
trait ArchimedeanAdditiveMonoid[X]
  extends ArchimedeanAdditiveSemigroup[X],
          ArchimedeanAdditiveIdentity[X],
          OrderedAdditiveMonoid[X]
