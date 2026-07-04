package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.lattice.BoundedJoinSemilattice

/**
  * Evidence that single-argument functions form a [[BoundedJoinSemilattice]]
  * under pointwise disjunction, provided the return type has a
  * [[BoundedJoinSemilattice]] instance.
  */
trait FunctionIsBoundedJoinSemilattice:

  given [X, Y : BoundedJoinSemilattice as Y] => BoundedJoinSemilattice[X => Y]:

    override def bottom: X => Y = _ => Y.bottom

    extension (f: X => Y) override def or(g: X => Y): X => Y = x => f(x) | g(x)
