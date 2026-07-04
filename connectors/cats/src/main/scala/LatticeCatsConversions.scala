package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.lattice.Lattice]] and
  * [[algebra.lattice.Lattice]].
  */
trait LatticeCatsConversions:

  /**
    * Derives an [[algebra.lattice.Lattice]] from a
    * [[scalgebra.lattice.Lattice]].
    */
  given latticeToCats
    : [X : scalgebra.lattice.Lattice as S] => algebra.lattice.Lattice[X]:

    def join(x: X, y: X): X = x | y
    def meet(x: X, y: X): X = x & y

  /**
    * Derives a [[scalgebra.lattice.Lattice]] from an
    * [[algebra.lattice.Lattice]].
    */
  given latticeFromCats
    : [X : algebra.lattice.Lattice as S] => scalgebra.lattice.Lattice[X]:

    extension (x: X)

      override def or(y: X): X  = S.join(x, y)
      override def and(y: X): X = S.meet(x, y)
