package com.alecdorrington.scalgebra
package lattice

/**
  * A typeclass for algebraic values with the following features:
  *   - Conjunction (and)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Associativity: `(x & y) & z == x & (y & z)`.
  *   - Commutativity: `x & y == y & x`.
  *   - Idempotence: `x & x == x`.
  */
trait MeetSemilattice[X] extends Algebra[X]:

  extension (x: X)

    /**
      * Computes the conjunction (meet) of two values [[x]] and [[y]], i.e.
      * `x ∧ y`.
      */
    def and(y: X): X

    /** An alias for [[and]]. */
    inline infix def & (y: X): X = x.and(y)
