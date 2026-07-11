package com.alecdorrington.scalgebra
package lattice

/**
  * A typeclass for algebraic values with the following features:
  *   - Conjunction (and)
  *   - Greatest element (`⊤`)
  *
  * @note
  *   Laws, in addition to those inherited:
  *   - Identity: `x & top == top & x == x`.
  */
trait BoundedMeetSemilattice[X] extends MeetSemilattice[X], MeetIdentity[X]
