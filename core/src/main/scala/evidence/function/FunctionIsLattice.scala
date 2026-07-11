package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.lattice.Lattice

/**
  * Evidence that single-argument functions form a [[Lattice]] under pointwise
  * disjunction and conjunction, provided the return type has a [[Lattice]]
  * instance.
  */
trait FunctionIsLattice:

  given [X, Y : Lattice as Y] => Lattice[X => Y]:

    extension (f: X => Y)

      override def or(g: X => Y): X => Y  = x => f(x) | g(x)
      override def and(g: X => Y): X => Y = x => f(x) & g(x)
