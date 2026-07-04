package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.lattice.JoinSemilattice

/**
  * Evidence that single-argument functions form a [[JoinSemilattice]] under
  * pointwise disjunction, provided the return type has a [[JoinSemilattice]]
  * instance.
  */
trait FunctionIsJoinSemilattice:

  given [X, Y : JoinSemilattice as Y] => JoinSemilattice[X => Y]:
    extension (f: X => Y) override def or(g: X => Y): X => Y = x => f(x) | g(x)
