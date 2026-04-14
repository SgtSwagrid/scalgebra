package io.github.sgtswagrid.structures
package evidence
package numeric

import io.github.sgtswagrid.structures.ordered.OrderedField

/**
  * Evidence that any type with a [[scala.math.Fractional]] instance forms an
  * [[OrderedField]] under standard fractional arithmetic.
  */
trait FractionalIsOrderedField:

  given [A : Fractional as num]: OrderedField[A] with

    override inline def add(x: A, y: A): A      = num.plus(x, y)
    override inline def negate(x: A): A         = num.negate(x)
    override inline def multiply(x: A, y: A): A = num.times(x, y)
    override inline def reciprocate(x: A): A    = num.div(num.one, x)
    override def one: A                         = num.one
    override def zero: A                        = num.zero
    override def compare(x: A, y: A): Int       = num.compare(x, y)
