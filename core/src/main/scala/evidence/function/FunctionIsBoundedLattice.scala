package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.lattice.BoundedLattice

/**
  * Evidence that single-argument functions form a [[BoundedLattice]] under
  * pointwise disjunction and conjunction, provided the return type has a
  * [[BoundedLattice]] instance.
  */
trait FunctionIsBoundedLattice:

  given [X, Y : BoundedLattice as Y] => BoundedLattice[X => Y]:

    override def bottom: X => Y = _ => Y.bottom
    override def top: X => Y    = _ => Y.top

    extension (f: X => Y)

      override def or(g: X => Y): X => Y  = x => f(x) | g(x)
      override def and(g: X => Y): X => Y = x => f(x) & g(x)
