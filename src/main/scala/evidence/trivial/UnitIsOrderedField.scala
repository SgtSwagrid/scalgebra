package io.github.sgtswagrid.structures
package evidence
package trivial

import io.github.sgtswagrid.structures.ordered.OrderedField

/**
  * Evidence that [[Unit]] forms an [[OrderedField]] as the trivial
  * single-element algebra.
  */
trait UnitIsOrderedField:

  given OrderedField[Unit] with

    override def negate(x: Unit): Unit            = ()
    override def add(x: Unit, y: Unit): Unit      = ()
    override def reciprocate(x: Unit): Unit       = ()
    override def multiply(x: Unit, y: Unit): Unit = ()
    override def one: Unit                        = ()
    override def zero: Unit                       = ()
    override def compare(x: Unit, y: Unit): Int   = 0
