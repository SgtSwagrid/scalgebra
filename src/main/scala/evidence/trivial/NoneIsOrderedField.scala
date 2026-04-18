package com.alecdorrington.scalgebra
package evidence
package trivial

import com.alecdorrington.scalgebra.ordered.OrderedField

/**
  * Evidence that [[None]] forms an [[OrderedField]] as the trivial
  * single-element algebra.
  */
trait NoneIsOrderedField:

  given OrderedField[None.type] with

    override def negate(x: None.type): None.type                 = None
    override def add(x: None.type, y: None.type): None.type      = None
    override def reciprocate(x: None.type): None.type            = None
    override def multiply(x: None.type, y: None.type): None.type = None
    override def one: None.type                                  = None
    override def zero: None.type                                 = None
    override def compare(x: None.type, y: None.type): Int        = 0
