package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.lattice.BoundedJoinSemilattice]]
  * and [[algebra.lattice.BoundedJoinSemilattice]].
  */
trait BoundedJoinSemilatticeCatsConversions:

  /**
    * Derives an [[algebra.lattice.BoundedJoinSemilattice]] from a
    * [[scalgebra.lattice.BoundedJoinSemilattice]].
    */
  given boundedJoinSemilatticeToCats
    : [X : scalgebra.lattice.BoundedJoinSemilattice as S]
      => algebra.lattice.BoundedJoinSemilattice[X]:

    def join(x: X, y: X): X = x | y
    def zero: X             = S.bottom

  /**
    * Derives a [[scalgebra.lattice.BoundedJoinSemilattice]] from an
    * [[algebra.lattice.BoundedJoinSemilattice]].
    */
  given boundedJoinSemilatticeFromCats
    : [X : algebra.lattice.BoundedJoinSemilattice as S]
      => scalgebra.lattice.BoundedJoinSemilattice[X]:

    override def bottom: X                    = S.zero
    extension (x: X) override def or(y: X): X = S.join(x, y)
