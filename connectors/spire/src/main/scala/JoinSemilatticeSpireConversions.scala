package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.lattice.JoinSemilattice]] and
  * [[spire.algebra.lattice.JoinSemilattice]].
  */
trait JoinSemilatticeSpireConversions:

  /**
    * Derives a [[spire.algebra.lattice.JoinSemilattice]] from a
    * [[scalgebra.lattice.JoinSemilattice]].
    */
  given joinSemilatticeToSpire
    : [X : scalgebra.lattice.JoinSemilattice as S]
      => algebra.lattice.JoinSemilattice[X]:
    def join(x: X, y: X): X = x | y

  /**
    * Derives a [[scalgebra.lattice.JoinSemilattice]] from a
    * [[spire.algebra.lattice.JoinSemilattice]].
    */
  given joinSemilatticeFromSpire
    : [X : algebra.lattice.JoinSemilattice as S]
      => scalgebra.lattice.JoinSemilattice[X]:
    extension (x: X) override def or(y: X): X = S.join(x, y)
