package com.alecdorrington.scalgebra
package lattice

/**
  * A typeclass for algebraic values with the following features:
  *   - Disjunction (or)
  *   - Least element (`⊥`)
  *   - Conjunction (and)
  *   - Greatest element (`⊤`)
  */
trait BoundedLattice[X]
  extends Lattice[X], BoundedJoinSemilattice[X], BoundedMeetSemilattice[X]
