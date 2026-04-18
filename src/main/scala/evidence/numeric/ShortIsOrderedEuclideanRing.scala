package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedEuclideanRing

/**
  * Evidence that [[Short]] forms an [[OrderedEuclideanRing]] under standard
  * 16-bit integer arithmetic.
  */
trait ShortIsOrderedEuclideanRing:

  given OrderedEuclideanRing[Short] with

    override inline def negate(x: Short): Short             = (-x).toShort
    override inline def add(x: Short, y: Short): Short      = (x + y).toShort
    override inline def divide(x: Short, y: Short): Short   = (x / y).toShort
    override inline def multiply(x: Short, y: Short): Short = (x * y).toShort
    override def one: Short                                 = 1
    override def zero: Short                                = 0
    override def compare(x: Short, y: Short): Int           = x.compareTo(y)
