package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.lattice.{BoundedJoinSemilattice, Lattice}

/**
  * Evidence that [[Set]] forms a [[Lattice]] and a [[BoundedJoinSemilattice]],
  * with union as disjunction, intersection as conjunction, and the empty set as
  * `⊥`. There is no greatest element, as the universal set isn't representable.
  */
trait SetIsLattice:

  given [X] => Lattice[Set[X]] & BoundedJoinSemilattice[Set[X]] =
    new Lattice[Set[X]] with BoundedJoinSemilattice[Set[X]]:

      override def bottom: Set[X] = Set.empty

      extension (x: Set[X])

        override def or(y: Set[X]): Set[X]  = x | y
        override def and(y: Set[X]): Set[X] = x & y
