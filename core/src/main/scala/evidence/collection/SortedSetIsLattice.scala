package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.lattice.{BoundedJoinSemilattice, Lattice}
import scala.collection.immutable.SortedSet

/**
  * Evidence that [[SortedSet]] forms a [[Lattice]] and a
  * [[BoundedJoinSemilattice]], with union as disjunction, intersection as
  * conjunction, and the empty set as `⊥`. There is no greatest element, as the
  * universal set isn't representable.
  */
trait SortedSetIsLattice:

  given [X : Ordering]
    => Lattice[SortedSet[X]] & BoundedJoinSemilattice[SortedSet[X]] =
    new Lattice[SortedSet[X]] with BoundedJoinSemilattice[SortedSet[X]]:

      override def bottom: SortedSet[X] = SortedSet.empty

      extension (x: SortedSet[X])

        override def or(y: SortedSet[X]): SortedSet[X]  = x | y
        override def and(y: SortedSet[X]): SortedSet[X] = x & y
