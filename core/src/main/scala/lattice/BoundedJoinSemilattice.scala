package com.alecdorrington.scalgebra
package lattice

/**
  * A typeclass for algebraic values with the following features:
  *   - Disjunction (or)
  *   - Least element (`⊥`)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Identity: `x | bottom == bottom | x == x`.
  */
trait BoundedJoinSemilattice[X] extends JoinSemilattice[X], JoinIdentity[X]
