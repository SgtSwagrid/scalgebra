package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.lattice.MeetSemilattice

/**
  * Evidence that single-argument functions form a [[MeetSemilattice]] under
  * pointwise conjunction, provided the return type has a [[MeetSemilattice]]
  * instance.
  */
trait FunctionIsMeetSemilattice:

  given [X, Y : MeetSemilattice as Y] => MeetSemilattice[X => Y]:
    extension (f: X => Y) override def and(g: X => Y): X => Y = x => f(x) & g(x)
