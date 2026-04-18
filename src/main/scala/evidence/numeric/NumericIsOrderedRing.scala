package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedRing

/**
  * Evidence that any type with a [[scala.math.Numeric]] instance forms an
  * [[OrderedRing]] under standard numeric arithmetic.
  */
trait NumericIsOrderedRing:

  given [A : Numeric as num]: OrderedRing[A] with

    override inline def add(x: A, y: A): A      = num.plus(x, y)
    override inline def negate(x: A): A         = num.negate(x)
    override inline def multiply(x: A, y: A): A = num.times(x, y)
    override def one: A                         = num.one
    override def zero: A                        = num.zero
    override def compare(x: A, y: A): Int       = num.compare(x, y)
