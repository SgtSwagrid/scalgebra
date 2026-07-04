package com.alecdorrington.scalgebra
package lattice

/**
  * A typeclass for algebraic values with the following features:
  *   - Disjunction (or)
  *   - Least element (`⊥`)
  *   - Conjunction (and)
  *   - Greatest element (`⊤`)
  *   - Complement (not)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Distributivity: `x & (y | z) == (x & y) | (x & z)` and
  *     `x | (y & z) == (x | y) & (x | z)`.
  *   - Complementation: `x & !x == bottom` and `x | !x == top`.
  */
trait BooleanAlgebra[X] extends BoundedLattice[X]:

  extension (x: X)

    /** Computes the complement of [[x]], i.e. `¬x`. */
    def not: X

    /**
      * Computes the implication (material conditional) of two values [[x]] and
      * [[y]], i.e. `x → y`.
      */
    infix def implies(y: X): X = !x | y

    /**
      * Computes the exclusive disjunction (symmetric difference) of two values
      * [[x]] and [[y]], i.e. `x ⊕ y`.
      */
    def xor(y: X): X = (x | y) & !(x & y)

    /** An alias for [[not]]. */
    inline def unary_! : X = x.not

    /** An alias for [[xor]]. */
    inline infix def ^ (y: X): X = x.xor(y)
