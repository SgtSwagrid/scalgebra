package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedEuclideanRing

/**
  * Evidence that any type with a [[scala.math.Integral]] instance forms an
  * [[OrderedEuclideanRing]] under standard integer arithmetic.
  */
trait IntegralIsOrderedEuclideanRing:

  given [A : Integral as num]: OrderedEuclideanRing[A] with

    override inline def add(x: A, y: A): A      = num.plus(x, y)
    override inline def negate(x: A): A         = num.negate(x)
    override inline def multiply(x: A, y: A): A = num.times(x, y)
    override inline def divide(x: A, y: A): A   = num.quot(x, y)
    override def one: A                         = num.one
    override def zero: A                        = num.zero
    override def compare(x: A, y: A): Int       = num.compare(x, y)
