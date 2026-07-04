package com.alecdorrington.scalgebra
package evidence
package trivial

import com.alecdorrington.scalgebra.arithmetic.Field
import com.alecdorrington.scalgebra.ordered.OrderedRing

/**
  * Evidence that [[EmptyTuple]] forms an [[OrderedRing]] as the trivial
  * single-element algebra (the zero ring).
  *
  * @note
  *   The zero ring is deliberately not given [[Field]] evidence: `zero == one`
  *   here, which the field axioms exclude, and generic code over fields may
  *   rely on that exclusion.
  */
trait EmptyTupleIsOrderedRing:

  given OrderedRing[EmptyTuple]:

    override def zero: EmptyTuple                           = EmptyTuple
    override def one: EmptyTuple                            = EmptyTuple
    override def compare(x: EmptyTuple, y: EmptyTuple): Int = 0

    extension (x: EmptyTuple)

      override def add(y: EmptyTuple): EmptyTuple = EmptyTuple
      override def negate: EmptyTuple             = EmptyTuple
      override def mul(y: EmptyTuple): EmptyTuple = EmptyTuple
