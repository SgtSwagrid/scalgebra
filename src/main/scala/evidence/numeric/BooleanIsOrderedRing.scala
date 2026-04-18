package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedRing

/**
  * Evidence that [[Boolean]] forms an [[OrderedRing]] over `GF(2)`, with `XOR`
  * as addition and `AND` as multiplication.
  */
trait BooleanIsOrderedRing:

  given OrderedRing[Boolean] with

    override def negate(x: Boolean): Boolean               = !x
    override def add(x: Boolean, y: Boolean): Boolean      = x ^ y
    override def multiply(x: Boolean, y: Boolean): Boolean = x & y
    override def one: Boolean                              = true
    override def zero: Boolean                             = false
    override def compare(x: Boolean, y: Boolean): Int      = x.compareTo(y)
