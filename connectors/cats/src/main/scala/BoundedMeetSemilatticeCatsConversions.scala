package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.lattice.BoundedMeetSemilattice]]
  * and [[algebra.lattice.BoundedMeetSemilattice]].
  */
trait BoundedMeetSemilatticeCatsConversions:

  /**
    * Derives an [[algebra.lattice.BoundedMeetSemilattice]] from a
    * [[scalgebra.lattice.BoundedMeetSemilattice]].
    */
  given boundedMeetSemilatticeToCats
    : [X : scalgebra.lattice.BoundedMeetSemilattice as S]
      => algebra.lattice.BoundedMeetSemilattice[X]:

    def meet(x: X, y: X): X = x & y
    def one: X              = S.top

  /**
    * Derives a [[scalgebra.lattice.BoundedMeetSemilattice]] from an
    * [[algebra.lattice.BoundedMeetSemilattice]].
    */
  given boundedMeetSemilatticeFromCats
    : [X : algebra.lattice.BoundedMeetSemilattice as S]
      => scalgebra.lattice.BoundedMeetSemilattice[X]:

    override def top: X                        = S.one
    extension (x: X) override def and(y: X): X = S.meet(x, y)
