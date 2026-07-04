package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.lattice.BoundedLattice]] and
  * [[spire.algebra.lattice.BoundedLattice]].
  */
trait BoundedLatticeSpireConversions:

  /**
    * Derives a [[spire.algebra.lattice.BoundedLattice]] from a
    * [[scalgebra.lattice.BoundedLattice]].
    */
  given boundedLatticeToSpire
    : [X : scalgebra.lattice.BoundedLattice as S]
      => algebra.lattice.BoundedLattice[X]:

    def join(x: X, y: X): X = x | y
    def meet(x: X, y: X): X = x & y
    def zero: X             = S.bottom
    def one: X              = S.top

  /**
    * Derives a [[scalgebra.lattice.BoundedLattice]] from a
    * [[spire.algebra.lattice.BoundedLattice]].
    */
  given boundedLatticeFromSpire
    : [X : algebra.lattice.BoundedLattice as S]
      => scalgebra.lattice.BoundedLattice[X]:

    override def bottom: X = S.zero
    override def top: X    = S.one

    extension (x: X)

      override def or(y: X): X  = S.join(x, y)
      override def and(y: X): X = S.meet(x, y)
