package com.alecdorrington.scalgebra
package evidence
package trivial

import com.alecdorrington.scalgebra.arithmetic.Field
import com.alecdorrington.scalgebra.ordered.OrderedRing

/**
  * Evidence that [[None]] forms an [[OrderedRing]] as the trivial
  * single-element algebra (the zero ring).
  *
  * @note
  *   The zero ring is deliberately not given [[Field]] evidence: `zero == one`
  *   here, which the field axioms exclude, and generic code over fields may
  *   rely on that exclusion.
  */
trait NoneIsOrderedRing:

  given OrderedRing[None.type]:

    override def zero: None.type                          = None
    override def one: None.type                           = None
    override def compare(x: None.type, y: None.type): Int = 0

    extension (x: None.type)

      override def add(y: None.type): None.type = None
      override def negate: None.type            = None
      override def mul(y: None.type): None.type = None
