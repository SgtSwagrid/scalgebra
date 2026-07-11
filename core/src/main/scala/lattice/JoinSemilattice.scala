package com.alecdorrington.scalgebra
package lattice

/**
  * A typeclass for algebraic values with the following features:
  *   - Disjunction (or)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Associativity: `(x | y) | z == x | (y | z)`.
  *   - Commutativity: `x | y == y | x`.
  *   - Idempotence: `x | x == x`.
  */
trait JoinSemilattice[X] extends Algebra[X]:

  extension (x: X)

    /**
      * Computes the disjunction (join) of two values [[x]] and [[y]], i.e.
      * `x ∨ y`.
      */
    def or(y: X): X

    /** An alias for [[or]]. */
    inline infix def | (y: X): X = x.or(y)
