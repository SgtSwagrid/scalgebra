package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.lattice.BooleanAlgebra

/**
  * Evidence that [[Boolean]] forms a [[BooleanAlgebra]] in the canonical way,
  * with `OR` as disjunction, `AND` as conjunction, and `NOT` as complement.
  */
trait BooleanIsBooleanAlgebra:

  given BooleanAlgebra[Boolean]:

    override def bottom: Boolean = false
    override def top: Boolean    = true

    extension (x: Boolean)

      override def or(y: Boolean): Boolean  = x | y
      override def and(y: Boolean): Boolean = x & y
      override def not: Boolean             = !x
