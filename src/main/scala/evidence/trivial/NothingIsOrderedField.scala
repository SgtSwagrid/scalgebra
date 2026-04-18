package com.alecdorrington.scalgebra
package evidence
package trivial

import com.alecdorrington.scalgebra.ordered.OrderedField

/**
  * Evidence that [[Nothing]] forms an [[OrderedField]] vacuously, as no values
  * of this type exist.
  */
trait NothingIsOrderedField:

  given OrderedField[Nothing] with

    private def error = throw IllegalStateException()

    override def negate(x: Nothing): Nothing               = error
    override def add(x: Nothing, y: Nothing): Nothing      = error
    override def reciprocate(x: Nothing): Nothing          = error
    override def multiply(x: Nothing, y: Nothing): Nothing = error
    override def one: Nothing                              = error
    override def zero: Nothing                             = error
    override def compare(x: Nothing, y: Nothing): Int      = error
