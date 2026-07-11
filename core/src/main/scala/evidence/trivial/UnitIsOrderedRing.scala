package com.alecdorrington.scalgebra
package evidence
package trivial

import com.alecdorrington.scalgebra.arithmetic.Field
import com.alecdorrington.scalgebra.ordered.OrderedRing

/**
  * Evidence that [[Unit]] forms an [[OrderedRing]] as the trivial
  * single-element algebra (the zero ring).
  *
  * @note
  *   The zero ring is deliberately not given [[Field]] evidence: `zero == one`
  *   here, which the field axioms exclude, and generic code over fields may
  *   rely on that exclusion.
  */
trait UnitIsOrderedRing:

  given OrderedRing[Unit]:

    override def zero: Unit                     = ()
    override def one: Unit                      = ()
    override def compare(x: Unit, y: Unit): Int = 0

    extension (x: Unit)

      override def add(y: Unit): Unit = ()
      override def negate: Unit       = ()
      override def mul(y: Unit): Unit = ()
