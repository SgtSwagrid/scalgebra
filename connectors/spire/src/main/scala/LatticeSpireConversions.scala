package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.lattice.Lattice]] and
  * [[spire.algebra.lattice.Lattice]].
  */
trait LatticeSpireConversions:

  /**
    * Derives a [[spire.algebra.lattice.Lattice]] from a
    * [[scalgebra.lattice.Lattice]].
    */
  given latticeToSpire
    : [X : scalgebra.lattice.Lattice as S] => algebra.lattice.Lattice[X]:

    def join(x: X, y: X): X = x | y
    def meet(x: X, y: X): X = x & y

  /**
    * Derives a [[scalgebra.lattice.Lattice]] from a
    * [[spire.algebra.lattice.Lattice]].
    */
  given latticeFromSpire
    : [X : algebra.lattice.Lattice as S] => scalgebra.lattice.Lattice[X]:

    extension (x: X)

      override def or(y: X): X  = S.join(x, y)
      override def and(y: X): X = S.meet(x, y)
