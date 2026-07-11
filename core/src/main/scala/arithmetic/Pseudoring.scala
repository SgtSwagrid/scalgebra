package com.alecdorrington.scalgebra
package arithmetic

/**
  * A typeclass for algebraic values with the following features:
  *   - Associative addition
  *   - Additive identity (`0`)
  *   - Additive inverse (negation)
  *   - Associative multiplication
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Commutativity: `x + y == y + x`.
  *   - Distributivity: `x × (y + z) == (x × y) + (x × z)` and
  *     `(x + y) × z == (x × z) + (y × z)`.
  */
trait Pseudoring[X] extends AdditiveGroup[X], MultiplicativeSemigroup[X]
