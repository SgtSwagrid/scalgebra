package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.lattice.BoundedLattice]] and
  * [[algebra.lattice.BoundedLattice]].
  */
trait BoundedLatticeCatsConversions:

  /**
    * Derives an [[algebra.lattice.BoundedLattice]] from a
    * [[scalgebra.lattice.BoundedLattice]].
    */
  given boundedLatticeToCats
    : [X : scalgebra.lattice.BoundedLattice as S]
      => algebra.lattice.BoundedLattice[X]:

    def join(x: X, y: X): X = x | y
    def meet(x: X, y: X): X = x & y
    def zero: X             = S.bottom
    def one: X              = S.top

  /**
    * Derives a [[scalgebra.lattice.BoundedLattice]] from an
    * [[algebra.lattice.BoundedLattice]].
    */
  given boundedLatticeFromCats
    : [X : algebra.lattice.BoundedLattice as S]
      => scalgebra.lattice.BoundedLattice[X]:

    override def bottom: X = S.zero
    override def top: X    = S.one

    extension (x: X)

      override def or(y: X): X  = S.join(x, y)
      override def and(y: X): X = S.meet(x, y)
