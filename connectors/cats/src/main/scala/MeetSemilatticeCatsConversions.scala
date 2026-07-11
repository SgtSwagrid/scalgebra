package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.lattice.MeetSemilattice]] and
  * [[algebra.lattice.MeetSemilattice]].
  */
trait MeetSemilatticeCatsConversions:

  /**
    * Derives an [[algebra.lattice.MeetSemilattice]] from a
    * [[scalgebra.lattice.MeetSemilattice]].
    */
  given meetSemilatticeToCats
    : [X : scalgebra.lattice.MeetSemilattice as S]
      => algebra.lattice.MeetSemilattice[X]:
    def meet(x: X, y: X): X = x & y

  /**
    * Derives a [[scalgebra.lattice.MeetSemilattice]] from an
    * [[algebra.lattice.MeetSemilattice]].
    */
  given meetSemilatticeFromCats
    : [X : algebra.lattice.MeetSemilattice as S]
      => scalgebra.lattice.MeetSemilattice[X]:
    extension (x: X) override def and(y: X): X = S.meet(x, y)
