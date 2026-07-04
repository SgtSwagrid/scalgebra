package com.alecdorrington.scalgebra
package evidence.function

import com.alecdorrington.scalgebra.lattice.BooleanAlgebra

/**
  * Evidence that single-argument functions form a [[BooleanAlgebra]] under
  * pointwise disjunction, conjunction, and complement, provided the return type
  * has a [[BooleanAlgebra]] instance.
  *
  * In particular, predicates (i.e. `X => Boolean`) form a Boolean algebra.
  */
trait FunctionIsBooleanAlgebra:

  given [X, Y : BooleanAlgebra as Y] => BooleanAlgebra[X => Y]:

    override def bottom: X => Y = _ => Y.bottom
    override def top: X => Y    = _ => Y.top

    extension (f: X => Y)

      override def or(g: X => Y): X => Y  = x => f(x) | g(x)
      override def and(g: X => Y): X => Y = x => f(x) & g(x)
      override def not: X => Y            = x => !f(x)
