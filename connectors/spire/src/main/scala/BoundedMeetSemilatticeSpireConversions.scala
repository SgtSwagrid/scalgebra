package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.lattice.BoundedMeetSemilattice]]
  * and [[spire.algebra.lattice.BoundedMeetSemilattice]].
  */
trait BoundedMeetSemilatticeSpireConversions:

  /**
    * Derives a [[spire.algebra.lattice.BoundedMeetSemilattice]] from a
    * [[scalgebra.lattice.BoundedMeetSemilattice]].
    */
  given boundedMeetSemilatticeToSpire
    : [X : scalgebra.lattice.BoundedMeetSemilattice as S]
      => algebra.lattice.BoundedMeetSemilattice[X]:

    def meet(x: X, y: X): X = x & y
    def one: X              = S.top

  /**
    * Derives a [[scalgebra.lattice.BoundedMeetSemilattice]] from a
    * [[spire.algebra.lattice.BoundedMeetSemilattice]].
    */
  given boundedMeetSemilatticeFromSpire
    : [X : algebra.lattice.BoundedMeetSemilattice as S]
      => scalgebra.lattice.BoundedMeetSemilattice[X]:

    override def top: X                        = S.one
    extension (x: X) override def and(y: X): X = S.meet(x, y)
