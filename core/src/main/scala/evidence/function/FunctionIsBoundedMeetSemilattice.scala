package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.lattice.BoundedMeetSemilattice

/**
  * Evidence that single-argument functions form a [[BoundedMeetSemilattice]]
  * under pointwise conjunction, provided the return type has a
  * [[BoundedMeetSemilattice]] instance.
  */
trait FunctionIsBoundedMeetSemilattice:

  given [X, Y : BoundedMeetSemilattice as Y] => BoundedMeetSemilattice[X => Y]:

    override def top: X => Y = _ => Y.top

    extension (f: X => Y) override def and(g: X => Y): X => Y = x => f(x) & g(x)
