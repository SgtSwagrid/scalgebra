package io.github.sgtswagrid.structures
package evidence
package numeric

import io.github.sgtswagrid.structures.ordered.OrderedField

/**
  * Evidence that [[Float]] forms an [[OrderedField]] under single-precision
  * floating-point arithmetic.
  */
trait FloatIsOrderedField:

  given OrderedField[Float] with

    override def negate(x: Float): Float             = -x
    override def add(x: Float, y: Float): Float      = x + y
    override def reciprocate(x: Float): Float        = 1.0F / x
    override def multiply(x: Float, y: Float): Float = x * y
    override def one: Float                          = 1.0F
    override def zero: Float                         = 0.0F
    override def compare(x: Float, y: Float): Int    = x.compareTo(y)
