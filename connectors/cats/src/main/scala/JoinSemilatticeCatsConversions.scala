package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.lattice.JoinSemilattice]] and
  * [[algebra.lattice.JoinSemilattice]].
  */
trait JoinSemilatticeCatsConversions:

  /**
    * Derives an [[algebra.lattice.JoinSemilattice]] from a
    * [[scalgebra.lattice.JoinSemilattice]].
    */
  given joinSemilatticeToCats
    : [X : scalgebra.lattice.JoinSemilattice as S]
      => algebra.lattice.JoinSemilattice[X]:
    def join(x: X, y: X): X = x | y

  /**
    * Derives a [[scalgebra.lattice.JoinSemilattice]] from an
    * [[algebra.lattice.JoinSemilattice]].
    */
  given joinSemilatticeFromCats
    : [X : algebra.lattice.JoinSemilattice as S]
      => scalgebra.lattice.JoinSemilattice[X]:
    extension (x: X) override def or(y: X): X = S.join(x, y)
