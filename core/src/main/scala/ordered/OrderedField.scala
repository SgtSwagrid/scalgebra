package com.alecdorrington.scalgebra
package ordered

import com.alecdorrington.scalgebra.arithmetic.Field

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *   - Multiplicative identity (`1`)
  *   - Multiplicative inverse (reciprocation)
  *   - Total order
  */
trait OrderedField[X]
  extends Field[X], OrderedQuotientRing[X], OrderedDifferenceSemifield[X]
