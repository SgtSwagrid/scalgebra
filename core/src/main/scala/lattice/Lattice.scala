package com.alecdorrington.scalgebra
package lattice

/**
  * A typeclass for algebraic values with the following features:
  *   - Disjunction (or)
  *   - Conjunction (and)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Absorption: `x | (x & y) == x` and `x & (x | y) == x`.
  */
trait Lattice[X] extends JoinSemilattice[X], MeetSemilattice[X]
