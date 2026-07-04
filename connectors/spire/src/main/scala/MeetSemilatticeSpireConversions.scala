package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.lattice.MeetSemilattice]] and
  * [[spire.algebra.lattice.MeetSemilattice]].
  */
trait MeetSemilatticeSpireConversions:

  /**
    * Derives a [[spire.algebra.lattice.MeetSemilattice]] from a
    * [[scalgebra.lattice.MeetSemilattice]].
    */
  given meetSemilatticeToSpire
    : [X : scalgebra.lattice.MeetSemilattice as S]
      => algebra.lattice.MeetSemilattice[X]:
    def meet(x: X, y: X): X = x & y

  /**
    * Derives a [[scalgebra.lattice.MeetSemilattice]] from a
    * [[spire.algebra.lattice.MeetSemilattice]].
    */
  given meetSemilatticeFromSpire
    : [X : algebra.lattice.MeetSemilattice as S]
      => scalgebra.lattice.MeetSemilattice[X]:
    extension (x: X) override def and(y: X): X = S.meet(x, y)
