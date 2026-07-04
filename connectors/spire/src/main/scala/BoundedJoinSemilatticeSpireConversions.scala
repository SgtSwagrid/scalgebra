package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.lattice.BoundedJoinSemilattice]]
  * and [[spire.algebra.lattice.BoundedJoinSemilattice]].
  */
trait BoundedJoinSemilatticeSpireConversions:

  /**
    * Derives a [[spire.algebra.lattice.BoundedJoinSemilattice]] from a
    * [[scalgebra.lattice.BoundedJoinSemilattice]].
    */
  given boundedJoinSemilatticeToSpire
    : [X : scalgebra.lattice.BoundedJoinSemilattice as S]
      => algebra.lattice.BoundedJoinSemilattice[X]:

    def join(x: X, y: X): X = x | y
    def zero: X             = S.bottom

  /**
    * Derives a [[scalgebra.lattice.BoundedJoinSemilattice]] from a
    * [[spire.algebra.lattice.BoundedJoinSemilattice]].
    */
  given boundedJoinSemilatticeFromSpire
    : [X : algebra.lattice.BoundedJoinSemilattice as S]
      => scalgebra.lattice.BoundedJoinSemilattice[X]:

    override def bottom: X                    = S.zero
    extension (x: X) override def or(y: X): X = S.join(x, y)
